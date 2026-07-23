package library.com.libraryapi.service;

import jakarta.transaction.Transactional;
import library.com.libraryapi.domain.Book;
import library.com.libraryapi.domain.Borrow;
import library.com.libraryapi.domain.User;
import library.com.libraryapi.repository.BookRepository;
import library.com.libraryapi.repository.BorrowRepository;
import library.com.libraryapi.repository.UserRepository;
import library.com.libraryapi.requested.BorrowRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class BorrowService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BorrowRepository borrowRepository;

    public List<Borrow> getAllBorrow(){
        return borrowRepository.findAll();
    }

    @Transactional(rollbackOn = Exception.class)
    public void UserIdBorrowBook(BorrowRequest request){
        User user = userRepository.findById(request.getUser())
                .orElseThrow(() -> new RuntimeException("User não encontrado"));

        Book book = bookRepository.findById(request.getBook())
                .orElseThrow(() -> new RuntimeException("Book não encontrado"));

        if (!book.isAvailable()){
            throw new RuntimeException("Book não esta disponivel");
        }

        book.setAvailable(false);
        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBook(book);
        borrowRepository.save(borrow);
    }

    @Transactional
    public void returnBorrowBook(Integer borrowId){

        Borrow borrow = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow não encontrado"));

        Book book = borrow.getBook();

        if(book.isAvailable()){
            throw new RuntimeException("Livro já foi devolvido");
        }

        book.setAvailable(true);

        borrowRepository.delete(borrow);

        log.info("Livro devolvido com sucesso");
    }
}

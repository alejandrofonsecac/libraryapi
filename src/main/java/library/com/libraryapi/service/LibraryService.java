package library.com.libraryapi.service;

import jakarta.transaction.Transactional;
import library.com.libraryapi.domain.Book;
import library.com.libraryapi.domain.User;
import library.com.libraryapi.mapper.LibraryMapper;
import library.com.libraryapi.mapper.UserMapper;
import library.com.libraryapi.repository.BookRepository;
import library.com.libraryapi.repository.UserRepository;
import library.com.libraryapi.requested.BookPostBodyRequest;
import library.com.libraryapi.requested.UserPostBodyRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
public class LibraryService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final LibraryMapper libraryMapper;
    private final UserMapper userMapper;

    @Transactional(rollbackOn = Exception.class)
    public Book registerBook(BookPostBodyRequest request){
        Book book = libraryMapper.toBook(request);
        return bookRepository.save(book);
    }

    @Transactional(rollbackOn = Exception.class)
    public User registerUser(UserPostBodyRequest request){
        User user = userMapper.registerUser(request);
        return userRepository.save(user);
    }


    //public Book borrowBook(){//Pegar livro emprestado
//
//    }
//
//    public void returnBook(){
//
//    }
//
//    public List<User> searchAllUsers(){
//
//    }
//
//    public List<Book> searchAllBooks(){
//
//    }
//
//    public List<Book> searchBookById(){
//
//    }
//
//    public List<Book> searchBookByName(){
//
//    }
}

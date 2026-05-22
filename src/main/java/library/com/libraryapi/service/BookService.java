package library.com.libraryapi.service;

import jakarta.transaction.Transactional;
import library.com.libraryapi.domain.Book;
import library.com.libraryapi.mapper.LibraryMapper;
import library.com.libraryapi.repository.BookRepository;
import library.com.libraryapi.requested.BookPostBodyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class BookService {
    private final BookRepository bookRepository;
    private final LibraryMapper libraryMapper;

    @Transactional(rollbackOn = Exception.class)
    public Book registerBook(BookPostBodyRequest request){
        Book book = libraryMapper.toBook(request);
        return bookRepository.save(book);
    }
}
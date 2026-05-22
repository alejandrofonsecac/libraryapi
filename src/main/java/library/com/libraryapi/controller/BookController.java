package library.com.libraryapi.controller;

import jakarta.validation.Valid;
import library.com.libraryapi.domain.Book;
import library.com.libraryapi.requested.BookPostBodyRequest;
import library.com.libraryapi.service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> registerBook(@RequestBody @Valid BookPostBodyRequest book){
        return new  ResponseEntity<>(bookService.registerBook(book), HttpStatus.CREATED);
    }
}
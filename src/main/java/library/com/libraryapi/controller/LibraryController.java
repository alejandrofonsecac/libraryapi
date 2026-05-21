package library.com.libraryapi.controller;

import jakarta.validation.Valid;
import library.com.libraryapi.domain.Book;
import library.com.libraryapi.domain.User;
import library.com.libraryapi.requested.BookPostBodyRequest;
import library.com.libraryapi.requested.UserPostBodyRequest;
import library.com.libraryapi.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/book")
@RestController
public class LibraryController {
    private final LibraryService libraryService;

    public ResponseEntity<Book> registerBook(@RequestBody @Valid BookPostBodyRequest book){
        return new  ResponseEntity<>(libraryService.registerBook(book), HttpStatus.CREATED);
    }


//    public ResponseEntity<Book> borrowBook(){//Pegar livro emprestado
//
//    }
//
//    public ResponseEntity<Void> returnBook(){
//
//    }
//
//    public ResponseEntity<List<User>> searchAllUsers(){
//
//    }
//
//    public ResponseEntity<List<Book>> searchAllBooks(){
//
//    }
//
//    public ResponseEntity<List<Book>> searchBookById(){
//
//    }
//
//    public ResponseEntity<List<Book>> searchBookByName(){
//
//    }
}
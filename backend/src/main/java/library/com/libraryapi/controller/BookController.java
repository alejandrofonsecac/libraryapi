package library.com.libraryapi.controller;

import library.com.libraryapi.DTO.BookResponseDTO;
import library.com.libraryapi.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping(path = "/books")
@RestController
public class BookController {
    private BookService bookService;

    @GetMapping
    public List<BookResponseDTO> getBooks() {
        return bookService.findAll();
    }
}

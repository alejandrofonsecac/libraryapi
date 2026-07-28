package library.com.libraryapi.service;

import library.com.libraryapi.DTO.BookResponseDTO;
import library.com.libraryapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public List<BookResponseDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(book -> new BookResponseDTO(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPrice(),
                        book.getStock(),
                        book.getCategory()
                )).toList();
    }
}

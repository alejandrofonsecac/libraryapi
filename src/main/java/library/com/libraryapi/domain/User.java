package library.com.libraryapi.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private int age;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private LocalDateTime ReturnDate = null;
    @ManyToOne
    private Book userBook;
}

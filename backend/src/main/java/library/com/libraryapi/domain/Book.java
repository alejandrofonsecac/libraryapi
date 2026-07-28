package library.com.libraryapi.domain;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "book")
@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private Long price;
    private int stock;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;
}

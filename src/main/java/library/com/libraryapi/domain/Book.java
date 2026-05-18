package library.com.libraryapi.domain;

import lombok.Data;

@Data
public class Book {
    Long id;
    String title;
    String description;
    String releaseDate;
}
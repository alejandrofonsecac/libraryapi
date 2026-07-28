package library.com.libraryapi.DTO;

import library.com.libraryapi.domain.Category;

public record BookResponseDTO (
        Integer id, String title, String author, Long price, int stock,  Category category
){

}

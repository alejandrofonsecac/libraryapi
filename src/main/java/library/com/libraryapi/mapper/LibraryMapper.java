package library.com.libraryapi.mapper;

import library.com.libraryapi.domain.Book;
import library.com.libraryapi.requested.BookPostBodyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LibraryMapper {
   @Mapping(target = "releaseDate", ignore = true)
   Book toBook(BookPostBodyRequest request);
}

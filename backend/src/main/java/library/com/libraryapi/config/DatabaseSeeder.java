package library.com.libraryapi.config;

import library.com.libraryapi.domain.Book;
import library.com.libraryapi.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner init(BookRepository repository) {
        return args -> {

            if (repository.count() > 0) {
                return;
            }

            ObjectMapper mapper = new ObjectMapper();

            InputStream input =
                    new ClassPathResource("books.json").getInputStream();

            List<Book> books = mapper.readValue(
                    input,
                    new TypeReference<List<Book>>() {}
            );
            repository.saveAll(books);
        };
    }
}
package library.com.libraryapi.requested;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserPostBodyRequest {
    @NotBlank
    private String name;
    private int age;
    private LocalDateTime loanDate =  LocalDateTime.now();
    private LocalDateTime ReturnDate = null;
    private String bookName = null;
}
package library.com.libraryapi.requested;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookPostBodyRequest {
    @NotBlank
    protected String title;
    protected String description;
    protected String releaseDate;
    protected Boolean available;
}

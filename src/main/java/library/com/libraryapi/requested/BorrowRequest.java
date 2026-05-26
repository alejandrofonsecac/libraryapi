package library.com.libraryapi.requested;

import lombok.Data;

@Data
public class BorrowRequest {
    private Long user;
    private Long book;
}

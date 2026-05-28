package library.com.libraryapi.controller;

import jakarta.validation.Valid;
import library.com.libraryapi.domain.Book;
import library.com.libraryapi.domain.Borrow;
import library.com.libraryapi.requested.BorrowRequest;
import library.com.libraryapi.service.BorrowService;
import library.com.libraryapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/borrows")
public class BorrowController {
    private final BorrowService borrowService;

    @PostMapping
    public ResponseEntity<Void> borrowBook(@RequestBody @Valid BorrowRequest request){
        borrowService.UserIdBorrowBook(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrow(){
        return new  ResponseEntity<>(borrowService.getAllBorrow(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> returnBook(@PathVariable @Valid Integer id){
        borrowService.returnBorrowBook(id);
        return ResponseEntity.ok().build();
    }
}

package library.com.libraryapi.controller;

import jakarta.validation.Valid;
import library.com.libraryapi.domain.Borrow;
import library.com.libraryapi.domain.User;
import library.com.libraryapi.requested.BorrowRequest;
import library.com.libraryapi.requested.UserPostBodyRequest;
import library.com.libraryapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserPostBodyRequest user){
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/borrows")
    public ResponseEntity<Void> borrowBook(@RequestBody @Valid BorrowRequest request){
        userService.UserIdBorrowBook(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
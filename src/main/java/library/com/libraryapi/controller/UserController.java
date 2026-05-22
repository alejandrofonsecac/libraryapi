package library.com.libraryapi.controller;

import jakarta.validation.Valid;
import library.com.libraryapi.domain.User;
import library.com.libraryapi.requested.UserPostBodyRequest;
import library.com.libraryapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserPostBodyRequest user){
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }
}
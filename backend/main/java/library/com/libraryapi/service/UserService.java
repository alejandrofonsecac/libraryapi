package library.com.libraryapi.service;

import jakarta.transaction.Transactional;
import library.com.libraryapi.domain.Book;
import library.com.libraryapi.domain.Borrow;
import library.com.libraryapi.domain.User;
import library.com.libraryapi.mapper.UserMapper;
import library.com.libraryapi.repository.BookRepository;
import library.com.libraryapi.repository.BorrowRepository;
import library.com.libraryapi.repository.UserRepository;
import library.com.libraryapi.requested.BorrowRequest;
import library.com.libraryapi.requested.UserPostBodyRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Log4j2
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BookRepository bookRepository;
    private final BorrowRepository borrowRepository;

    @Transactional(rollbackOn = Exception.class)
    public User registerUser(UserPostBodyRequest request){
        User user = userMapper.registerUser(request);
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.getReferenceById(id);
    }
}

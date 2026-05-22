package library.com.libraryapi.service;

import jakarta.transaction.Transactional;
import library.com.libraryapi.domain.User;
import library.com.libraryapi.mapper.UserMapper;
import library.com.libraryapi.repository.UserRepository;
import library.com.libraryapi.requested.UserPostBodyRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Transactional(rollbackOn = Exception.class)
    public User registerUser(UserPostBodyRequest request){
        User user = userMapper.registerUser(request);
        return userRepository.save(user);
    }
}

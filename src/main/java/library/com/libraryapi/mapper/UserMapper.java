package library.com.libraryapi.mapper;

import library.com.libraryapi.domain.User;
import library.com.libraryapi.requested.UserPostBodyRequest;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UserMapper{
    User registerUser(UserPostBodyRequest request);
}
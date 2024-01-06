package ru.example.springbootrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.springbootrest.constant.Authorities;
import ru.example.springbootrest.exception.UnauthorizedUser;
import ru.example.springbootrest.model.User;
import ru.example.springbootrest.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

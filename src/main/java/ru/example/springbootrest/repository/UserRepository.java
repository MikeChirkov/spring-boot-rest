package ru.example.springbootrest.repository;

import org.springframework.stereotype.Repository;
import ru.example.springbootrest.constant.Authorities;
import ru.example.springbootrest.model.User;

import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin"))
            return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        if (user.getUsername().equals("writer") && user.getPassword().equals("writer"))
            return List.of(Authorities.WRITE);
        if (user.getUsername().equals("reader") && user.getPassword().equals("reader"))
            return List.of(Authorities.WRITE);
        if (user.getUsername().equals("remover") && user.getPassword().equals("remover"))
            return List.of(Authorities.DELETE);
        return null;
    }
}

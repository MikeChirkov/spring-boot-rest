package ru.example.springbootrest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.springbootrest.constant.Authorities;
import ru.example.springbootrest.model.User;
import ru.example.springbootrest.service.AuthorizationService;

import java.util.List;

@AllArgsConstructor
@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}
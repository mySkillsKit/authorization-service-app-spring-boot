package ru.netology.authorizationserviceappspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationserviceappspringboot.model.Authorities;
import ru.netology.authorizationserviceappspringboot.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        System.out.format("[User: %s, password: %s] ", user, password);
        return service.getAuthorities(user, password);
    }

}

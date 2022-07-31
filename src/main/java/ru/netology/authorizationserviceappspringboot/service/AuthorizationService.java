package ru.netology.authorizationserviceappspringboot.service;

import org.springframework.stereotype.Service;
import ru.netology.authorizationserviceappspringboot.exception.InvalidCredentials;
import ru.netology.authorizationserviceappspringboot.exception.UnauthorizedUser;
import ru.netology.authorizationserviceappspringboot.model.Authorities;
import ru.netology.authorizationserviceappspringboot.model.User;
import ru.netology.authorizationserviceappspringboot.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getName(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

}

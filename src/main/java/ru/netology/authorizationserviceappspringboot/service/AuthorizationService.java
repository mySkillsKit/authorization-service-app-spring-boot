package ru.netology.authorizationserviceappspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.authorizationserviceappspringboot.exception.InvalidCredentials;
import ru.netology.authorizationserviceappspringboot.exception.UnauthorizedUser;
import ru.netology.authorizationserviceappspringboot.model.Authorities;
import ru.netology.authorizationserviceappspringboot.repository.UserRepository;
ø
import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
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

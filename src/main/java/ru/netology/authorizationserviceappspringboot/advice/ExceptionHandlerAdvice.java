package ru.netology.authorizationserviceappspringboot.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorizationserviceappspringboot.exception.InvalidCredentials;
import ru.netology.authorizationserviceappspringboot.exception.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    //InvalidCredentials --> http 400
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials exc) {
        exc.printStackTrace();
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //UnauthorizedUser --> http 401
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser exc) {
        exc.printStackTrace();
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}

package at.itkolleg.jokeapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(JokeNotFoundException.class)
    public ResponseEntity<String> genericException(JokeNotFoundException jokeNotFoundException){
        return new ResponseEntity<>(jokeNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}

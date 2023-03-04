package pl.sda.spring.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pl.sda.spring.demo.exception.IllegalValueException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({IllegalValueException.class})
    public ResponseEntity<String> handle(IllegalValueException ive, WebRequest request) {
        return ResponseEntity
                .badRequest()
                .body("Kontrolowana sytuacja, niepoprawna wartosc: " + ive.getMessage());
    }
}

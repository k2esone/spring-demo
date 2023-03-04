package pl.sda.spring.demo.exception;

public class IllegalValueException extends RuntimeException {
    public IllegalValueException(String message) {
        super("Niepoprawna wartosc pola: " + message);
    }
}

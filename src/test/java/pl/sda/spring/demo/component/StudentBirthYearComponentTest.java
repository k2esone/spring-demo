package pl.sda.spring.demo.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sda.spring.demo.exception.IllegalValueException;
import pl.sda.spring.demo.model.Student;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentBirthYearComponentTest {

    private final StudentBirthYearComponent birthYearComponent = new StudentBirthYearComponent();

    @Test
    @DisplayName("Oblicza poprawnie rok urodzenia jesli obiekt student posiada przypisana wartosc dla pola wiek")
    void testBirthYearCalculation() {
        // GIVEN
        final var student = new Student(null, null, null, 25);

        // THEN
        final var wynik = birthYearComponent.calculateBirthYear(student);

        // ASSERT
        assertEquals(LocalDate.now().getYear() - 25, wynik);
    }

    @Test
    @DisplayName("Rzuca InvalidArgumentException jesli wiek studenta nie posiada wartosci")
    void testBirthYearCalculationThrowsExceptionOnNull() {
        // GIVEN
        final var student = new Student(null, null, null, null);

        // THEN ASSERT
        assertThrows(IllegalValueException.class, () -> {
            birthYearComponent.calculateBirthYear(student);
        });
    }

}
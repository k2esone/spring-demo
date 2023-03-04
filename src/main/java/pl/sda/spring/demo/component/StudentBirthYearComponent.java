package pl.sda.spring.demo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.sda.spring.demo.exception.IllegalValueException;
import pl.sda.spring.demo.model.Student;

import java.time.LocalDate;

@Slf4j
@Component
public class StudentBirthYearComponent {

    public int calculateBirthYear(Student student) {
        if (student.getWiek() == null) {
            throw new IllegalValueException("Wiek jest null");
        }
        int year = LocalDate.now().getYear();
        return year - student.getWiek();
    }
}

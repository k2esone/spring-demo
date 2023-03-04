package pl.sda.spring.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO - Data Transfer Object - obiekt ktorego uzywamy do komunikacji [ klient <-> aplikacja ]
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {

    private String firstName; // mapowane na imie
    private String lastName;  // mapowane na nazwisko
    private Integer age;      // mapowane na wiek

}

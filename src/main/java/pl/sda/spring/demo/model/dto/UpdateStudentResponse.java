package pl.sda.spring.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentResponse {

    private Long identifier;
    private String firstName;
    private String lastName;
    private Integer age;
}

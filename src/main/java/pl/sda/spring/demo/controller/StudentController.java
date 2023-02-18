package pl.sda.spring.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.demo.model.Student;
import pl.sda.spring.demo.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // READ
    // http://localhost:8080/student
    @GetMapping()
    public List<Student> getStudentList() {
        log.info("Ktos zapytal o liste studentow.");
        return studentService.getAll();
    }

    // DELETE
    // http://localhost:8080/student?studentId=1
    @DeleteMapping()
    public void deleteStudent(@RequestParam Long studentId) {
        log.info("Ktos usunal studenta.");
        studentService.delete(studentId);

    }

}

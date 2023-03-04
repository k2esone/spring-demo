package pl.sda.spring.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.demo.model.Student;
import pl.sda.spring.demo.model.dto.CreateStudentRequest;
import pl.sda.spring.demo.model.dto.UpdateStudentRequest;
import pl.sda.spring.demo.model.dto.UpdateStudentResponse;
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
    @GetMapping("/birthyear")
    public int getBirthYear(@RequestParam Long sId) {
        log.info("Ktos zapytal o rok urodzenia studenta o id: {}", sId);
        return studentService.getBirthYearOfStudentWithId(sId);
    }

    // READ
    // http://localhost:8080/student
    @GetMapping()
    public List<Student> getStudentList() {
        log.info("Ktos zapytal o liste studentow.");
        return studentService.getAll();
    }

    // READ
    // http://localhost:8080/student/byId?studentId=1
    @GetMapping("/byId")
    public Student getStudentWithId(@RequestParam Long studentId) {
        log.info("Ktos zapytal o studenta z identyfikatorem: {}", studentId);
        return studentService.findById(studentId);
    }

    @GetMapping("/{identyfikator}")
    public Student getStudentById(@PathVariable Long identyfikator) {
        log.info("Ktos zapytal o studenta z identyfikatorem {}", identyfikator);
        return studentService.findById(identyfikator);
    }

    // DELETE
    // http://localhost:8080/student?id=1
    @DeleteMapping()
    public void deleteStudent(@RequestParam Long stId) {
        log.info("Ktos usunal studenta." + stId);
        studentService.delete(stId);
    }

    // CREATE
    // http://localhost:8080/student
    @PostMapping()
    public void createStudent(@RequestBody CreateStudentRequest request){
        log.info("Wywolano dodanie studenta: {}", request);
        studentService.createStudent(request);

    }

    // UPDATE
    @PatchMapping("/{studentId}")
    public UpdateStudentResponse updateStudent(@PathVariable Long studentId, @RequestBody UpdateStudentRequest request) {
        log.info("Wywolano aktualizacje studenta o id: {}, dane: {}", studentId, request);
        return studentService.update(studentId, request);
    }


}

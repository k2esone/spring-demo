package pl.sda.spring.demo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.spring.demo.component.StudentBirthYearComponent;
import pl.sda.spring.demo.model.Student;
import pl.sda.spring.demo.model.dto.CreateStudentRequest;
import pl.sda.spring.demo.model.dto.UpdateStudentRequest;
import pl.sda.spring.demo.model.dto.UpdateStudentResponse;
import pl.sda.spring.demo.repository.StudentRepository;

import java.util.List;

@Slf4j
@Service
public class StudentService {

    private StudentRepository studentRepository;
    private StudentBirthYearComponent birthYearComponent;

    public StudentService(StudentRepository studentRepository, StudentBirthYearComponent birthYearComponent) {
        this.studentRepository = studentRepository;
        this.birthYearComponent = birthYearComponent;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public int getBirthYearOfStudentWithId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono studenta o id " + studentId));
        return birthYearComponent.calculateBirthYear(student);
    }

//    public int getBirthYearOfStudentWithId(Long studentId) {
//        Optional<Student> studentOptional = studentRepository.findById(studentId);
//        if (studentOptional.isPresent()) {
//            Student student = studentOptional.get();
//
//            return birthYearComponent.calculateBirthYear(student);
//        }
//        throw new EntityNotFoundException("Nie znaleziono studenta o id " + studentId);
//    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student findById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono studenta o id: " + studentId));
    }

    public void createStudent(CreateStudentRequest request) {
//        Student student = new Student(null, request.getFirstName(), request.getLastName(), request.getAge());
        Student student = Student.builder()
                .imie(request.getFirstName())
                .nazwisko(request.getLastName())
                .wiek(request.getAge())
                .build();

        studentRepository.save(student);

    }

    public UpdateStudentResponse update(Long studentId, UpdateStudentRequest request) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono studenta o id " + studentId));
        if (request.getFirstName() != null) {
            student.setImie(request.getFirstName());
        }

        // W przypadku pozwolenia na edycje nazwiska

//        if (request.getLastName() != null) {
//            student.setNazwisko(request.getLastName());
//        }

        // etap zapisz aktualizowany obiekt, metoda save zwraca wynik po aktualizacji
        student = studentRepository.save(student);

        // zwroc response, nie studenta (nie entity!)
        return studentToStudentResponse(student);

    }

    private UpdateStudentResponse studentToStudentResponse(Student student) {
        return new UpdateStudentResponse(
                student.getId(),
                student.getImie(),
                student.getNazwisko(),
                student.getWiek()
        );
    }
}

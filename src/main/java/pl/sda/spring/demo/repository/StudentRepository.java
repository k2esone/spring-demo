package pl.sda.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.spring.demo.model.Student;

// CRUD
// create (save)
// read (findById, findAll)
// update (save)
// delete (delete, deleteById)
// exists
@Repository //kosmetycznie
public interface StudentRepository extends JpaRepository<Student, Long> {
}

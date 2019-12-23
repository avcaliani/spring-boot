package br.avcaliani.specification.app.service;

import br.avcaliani.specification.app.model.Student;
import br.avcaliani.specification.app.repository.StudentRepository;
import br.avcaliani.specification.app.specification.StudentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class StudentService implements Serializable {

    @Autowired
    private StudentRepository repository;

    /**
     * Find all students.
     *
     * @return List of students.
     */
    public List<Student> findAll() {
        return this.repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    /**
     * Find student by ID.
     *
     * @param id Student ID.
     * @return Student.
     */
    public Student find(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    /**
     * Find by email or passport.
     * <br>
     * Using Repository
     * --------------------------------------------------------------
     * return this.repository.findByEmailOrPassport(email, passport);
     * <br>
     * Using Named Query
     * --------------------------------------------------------------
     * return this.repository.find(email, passport);
     *
     * @param email    Student email.
     * @param passport Student passport.
     * @return Student.
     */
    public Student findByEmailOrPassport(String email, String passport) {

        /* Using Specification */
        List<Student> students = this.repository.findAll(
                Specification
                        .where(StudentSpecification.email(email))
                        .or(StudentSpecification.passport(passport))
        );

        return !students.isEmpty() ? students.get(0) : null;
    }
}

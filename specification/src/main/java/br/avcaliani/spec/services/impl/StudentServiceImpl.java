package br.avcaliani.spec.services.impl;

import br.avcaliani.spec.model.dtos.StudentDTO;
import br.avcaliani.spec.model.entities.Student;
import br.avcaliani.spec.repositories.StudentRepository;
import br.avcaliani.spec.services.StudentService;
import br.avcaliani.spec.specifications.StudentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<StudentDTO> findAll() {

        List<StudentDTO> dtos = new ArrayList<>();
        var students = this.repository.findAll(new Sort(Sort.Direction.ASC, "name"));

        for (Student student : students)
            dtos.add(new StudentDTO(student));

        return dtos;
    }

    @Override
    public StudentDTO find(Long id) throws Exception {
        return new StudentDTO(this.repository.getOne(id));
    }

    @Override
    public StudentDTO findByEmailOrPassport(String email, String passport) {

        /* Using Repository */
        // var student = this.repository.findByEmailOrPassport(email, passport);
        // return student != null ? new StudentDTO(student) : null;

        /* Using Named Query */
        // var student = this.repository.find(email, passport);
        // return student != null ? new StudentDTO(student) : null;

        /* Using Specification */
        var students = this.repository.findAll(
                Specification
                        .where(StudentSpecification.email(email))
                        .or(StudentSpecification.passport(passport))
        );
        return !students.isEmpty() ? new StudentDTO(students.get(0)) : null;
    }
}

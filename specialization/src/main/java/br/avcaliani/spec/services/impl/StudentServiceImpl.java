package br.avcaliani.spec.services.impl;

import br.avcaliani.spec.model.dtos.StudentDTO;
import br.avcaliani.spec.model.entities.Student;
import br.avcaliani.spec.repositories.StudentRepository;
import br.avcaliani.spec.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
        var students = this.repository.findAll();

        for (Student student : students)
            dtos.add(new StudentDTO(student));

        return dtos;
    }

    @Override
    public StudentDTO find(Long id) throws Exception {
        var student = this.repository.findById(id);

        if (student.isPresent())
            return new StudentDTO(student.get());

        throw new Exception("User not found!");
    }
}

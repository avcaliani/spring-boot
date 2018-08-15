package br.avcaliani.spec.services.impl;

import br.avcaliani.spec.entities.Student;
import br.avcaliani.spec.repositories.StudentRepository;
import br.avcaliani.spec.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Student find(Long id) throws Exception {
        var student = this.repository.findById(id);

        if (student.isPresent())
            return student.get();

        throw new Exception("User not found!");
    }
}

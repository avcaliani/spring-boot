package br.avcaliani.spec.services;

import br.avcaliani.spec.model.dtos.StudentDTO;
import br.avcaliani.spec.model.entities.Student;

import java.util.List;

public interface StudentService {

    /**
     * Find all students.
     * @return List of Students.
     */
    public List<StudentDTO> findAll();

    /**
     * Find student by ID.
     * @param id Student ID.
     * @return Student
     * @throws Exception If student doesn't exists.
     */
    public StudentDTO find(Long id) throws Exception;
}

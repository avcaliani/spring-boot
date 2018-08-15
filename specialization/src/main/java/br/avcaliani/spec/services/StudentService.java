package br.avcaliani.spec.services;

import br.avcaliani.spec.entities.Student;

import java.util.List;

public interface StudentService {

    /**
     * Find all students.
     * @return List of Students.
     */
    public List<Student> findAll();

    /**
     * Find student by ID.
     * @param id Student ID.
     * @return Student
     * @throws Exception If student doesn't exists.
     */
    public Student find(Long id) throws Exception;
}

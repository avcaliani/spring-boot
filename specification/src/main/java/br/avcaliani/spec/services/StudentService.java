package br.avcaliani.spec.services;

import br.avcaliani.spec.model.dtos.StudentDTO;

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

    /**
     * Find student by Name or Passport.
     * @param email Student Name.
     * @param passport Student Passport.
     * @return Student.
     */
    public StudentDTO findByEmailOrPassport(String email, String passport);
}

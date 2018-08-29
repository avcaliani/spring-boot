package br.avcaliani.spec.repositories;

import br.avcaliani.spec.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    /**
     * Find student by Name or Passport.
     * @param email Student Name.
     * @param passport Student Passport.
     * @return Student.
     */
    public Student findByEmailOrPassport(
            @Param("email") String email, @Param("passport") String passport
    );

    /**
     * Find student by Name or Passport.
     * @param email Student Name.
     * @param passport Student Passport.
     * @return Student.
     */
    @Query(value = "select s from Student s where s.email = :email or s.passport = :passport")
    public Student find(
            @Param("email") String email, @Param("passport") String passport
    );

}

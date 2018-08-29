package br.avcaliani.spec.model.entities;

import br.avcaliani.spec.model.dtos.StudentDTO;
import lombok.Data;
import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String passport;

    @Column(unique = true, nullable = false)
    private String email;

    /**
     * Default Constructor.
     */
    public Student() {
    }

    /**
     * Almost Complete Constructor.
     * This constructor will set all entity parameters except ID field.
     * @param name Student Name.
     * @param passport Student Passport.
     * @param email Student E-Mail.
     */
    public Student(String name, String passport, String email) {
        this.name = name;
        this.passport = passport;
        this.email = email;
    }

    /**
     * Complete Constructor.
     * This constructor will set all entity parameters.
     * @param id Student ID.
     * @param name Student Name.
     * @param passport Student Passport.
     * @param email Student E-Mail.
     */
    public Student(Long id, String name, String passport, String email) {
        this.id = id;
        this.name = name;
        this.passport = passport;
        this.email = email;
    }

    /**
     * DTO Converter Constructor.
     * @param dto Student DTO.
     */
    public Student(StudentDTO dto) {

        if (dto == null)
            return;

        this.id = dto.getId();
        this.name = dto.getName();
        this.passport = dto.getPassport();
        this.email = dto.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passport, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

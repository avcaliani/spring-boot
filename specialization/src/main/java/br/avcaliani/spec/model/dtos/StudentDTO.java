package br.avcaliani.spec.model.dtos;

import br.avcaliani.spec.model.entities.Student;
import lombok.Data;

import java.util.Objects;

@Data
public class StudentDTO {

    private Long id;
    private String name;
    private String passport;
    private String email;

    /**
     * Default Constructor.
     */
    public StudentDTO() {
    }

    /**
     * Almost Complete Constructor.
     * This constructor will set all entity parameters except ID field.
     * @param name Student Name.
     * @param passport Student Passport.
     * @param email Student E-Mail.
     */
    public StudentDTO(String name, String passport, String email) {
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
    public StudentDTO(Long id, String name, String passport, String email) {
        this.id = id;
        this.name = name;
        this.passport = passport;
        this.email = email;
    }

    /**
     * Entity Converter Constructor.
     * @param entity Entity.
     */
    public StudentDTO(Student entity) {

        if (entity == null)
            return;

        this.id = entity.getId();
        this.name = entity.getName();
        this.passport = entity.getPassport();
        this.email = entity.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO dto = (StudentDTO) o;
        return Objects.equals(id, dto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passport, email);
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package br.avcaliani.specification.app.specification;

import br.avcaliani.specification.app.model.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    /**
     * e-Mail specification.
     *
     * @param email e-mail value.
     * @return Specification.
     */
    public static Specification<Student> email(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
    }

    /**
     * Passport specification.
     *
     * @param passport Passport value.
     * @return Specification.
     */
    public static Specification<Student> passport(String passport) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("passport"), passport);
    }

    private StudentSpecification() { /* Avoiding new instances */ }

}

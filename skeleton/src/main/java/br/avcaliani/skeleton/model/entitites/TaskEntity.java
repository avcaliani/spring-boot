package br.avcaliani.skeleton.model.entitites;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "task")
@Table(indexes = {
        @Index(name = "description_index", columnList = "description")
})
@Data
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String owner;

    @Column(nullable = false)
    private String description;

    // @Column -> está subentendido aqui.
    private Boolean done;

    /**
     * Construtor Padrão. Usado para a conversão em/para JSON.
     */
    public TaskEntity() {

    }

}

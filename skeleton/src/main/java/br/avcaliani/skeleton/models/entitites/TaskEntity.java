package br.avcaliani.skeleton.models.entitites;

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

    // @Column -> You don't have to declare, but you can ;)
    private Boolean done;

    /**
     * Default Constructor. Used to convert in/to JSON.
     */
    public TaskEntity() {

    }

}

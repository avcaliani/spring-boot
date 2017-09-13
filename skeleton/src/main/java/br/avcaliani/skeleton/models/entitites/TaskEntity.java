package br.avcaliani.skeleton.models.entitites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    private Boolean ready;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SubTaskEntity> subTasks;

    /**
     * Default Constructor. Used to convert to/from JSON.
     */
    public TaskEntity() {

    }

}

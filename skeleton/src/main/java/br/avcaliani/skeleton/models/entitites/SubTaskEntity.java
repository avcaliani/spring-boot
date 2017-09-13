package br.avcaliani.skeleton.models.entitites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "sub_task")
public class SubTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean done;

    /**
     * Default Constructor. Used to convert to/from JSON.
     */
    public SubTaskEntity() {

    }

}

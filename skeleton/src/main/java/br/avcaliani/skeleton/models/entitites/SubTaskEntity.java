package br.avcaliani.skeleton.models.entitites;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "sub_task")
public class SubTaskEntity {

    @Id
    private Long id;

    @Column(length = 2)
    private int importance;

    @Column(length = 200)
    private String title;

    /**
     * Default Constructor. Used to convert to/from JSON.
     */
    public SubTaskEntity() {

    }

}

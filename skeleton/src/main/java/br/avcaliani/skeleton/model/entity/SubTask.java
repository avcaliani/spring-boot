package br.avcaliani.skeleton.model.entity;

import br.avcaliani.skeleton.exception.TaskException;
import br.avcaliani.skeleton.model.dto.SubTaskDTO;
import br.avcaliani.skeleton.util.Messages;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SubTask implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean done;

    /**
     * DTO Converter Constructor.
     *
     * @param dto SubTask DTO.
     */
    public SubTask(SubTaskDTO dto) {

        if (dto == null)
            throw new TaskException(Messages.NULL_SUB_TASK_DTO);

        this.id = dto.getId();
        this.description = dto.getDescription();
        this.done = dto.getDone();
    }

}

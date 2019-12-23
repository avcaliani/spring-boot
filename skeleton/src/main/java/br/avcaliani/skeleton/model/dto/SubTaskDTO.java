package br.avcaliani.skeleton.model.dto;

import br.avcaliani.skeleton.exception.TaskException;
import br.avcaliani.skeleton.model.entity.SubTask;
import br.avcaliani.skeleton.util.Messages;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SubTaskDTO implements Serializable {

    private Long id;
    private String description;
    private Boolean done;

    /**
     * Description Constructor.
     *
     * @param description Sub Task Description.
     */
    public SubTaskDTO(String description) {
        this.description = description;
    }

    /**
     * Entity Converter Constructor.
     *
     * @param entity SubTask.
     */
    public SubTaskDTO(SubTask entity) {

        if (entity == null)
            throw new TaskException(Messages.NULL_SUB_TASK_ENTITY);

        this.id = entity.getId();
        this.description = entity.getDescription();
        this.done = entity.getDone();
    }

}

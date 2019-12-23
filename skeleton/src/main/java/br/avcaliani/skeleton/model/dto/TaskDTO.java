package br.avcaliani.skeleton.model.dto;

import br.avcaliani.skeleton.exception.TaskException;
import br.avcaliani.skeleton.model.entity.Task;
import br.avcaliani.skeleton.util.Messages;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO implements Serializable {

    private Long id;
    private String owner;
    private String description;
    private Boolean ready;
    private List<SubTaskDTO> subTasks;

    /**
     * Entity Converter Constructor.
     *
     * @param entity Task.
     */
    public TaskDTO(Task entity) {

        if (entity == null)
            throw new TaskException(Messages.NULL_TASK_ENTITY);

        this.id = entity.getId();
        this.owner = entity.getOwner();
        this.description = entity.getDescription();
        this.ready = entity.getReady();

        if (entity.getSubTasks() != null && !entity.getSubTasks().isEmpty()) {
            this.subTasks = new ArrayList<>();
            entity.getSubTasks().forEach(
                    subTask -> this.subTasks.add(new SubTaskDTO(subTask)
                    ));
        }
    }

}

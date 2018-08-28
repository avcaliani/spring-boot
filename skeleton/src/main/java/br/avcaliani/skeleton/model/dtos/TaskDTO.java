package br.avcaliani.skeleton.model.dtos;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.model.entitites.Task;
import br.avcaliani.skeleton.utils.Messages;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class TaskDTO {

    private Long id;
    private String owner;
    private String description;
    private Boolean ready;
    private List<SubTaskDTO> subTasks;

    /**
     * Default Constructor.
     */
    public TaskDTO() {

    }

    /**
     * Entity Converter Constructor.
     * @param entity Task.
     */
    public TaskDTO(Task entity) throws TaskException {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskDTO)) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                ", ready=" + ready +
                '}';
    }
}

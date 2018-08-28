package br.avcaliani.skeleton.model.dtos;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.model.entitites.SubTask;
import br.avcaliani.skeleton.utils.Messages;
import lombok.Data;

import java.util.Objects;

@Data
public class SubTaskDTO {

    private Long id;
    private String description;
    private Boolean done;

    /**
     * Default Constructor. Used to convert to/from JSON.
     */
    public SubTaskDTO() {

    }

    /**
     * Description Constructor.
     * @param description Sub Task Description.
     */
    public SubTaskDTO(String description) {
        this.description = description;
    }

    /**
     * Entity Converter Constructor.
     * @param entity SubTask.
     */
    public SubTaskDTO(SubTask entity) throws TaskException {

        if (entity == null)
            throw new TaskException(Messages.NULL_SUB_TASK_ENTITY);

        this.id = entity.getId();
        this.description = entity.getDescription();
        this.done = entity.getDone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubTaskDTO)) return false;
        SubTaskDTO that = (SubTaskDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SubTaskDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }

}

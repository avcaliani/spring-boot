package br.avcaliani.skeleton.model.entitites;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.model.dtos.SubTaskDTO;
import br.avcaliani.skeleton.utils.Messages;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class SubTask {

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
    public SubTask() {

    }

    /**
     * DTO Converter Constructor.
     * @param dto SubTask DTO.
     */
    public SubTask(SubTaskDTO dto) throws TaskException {

        if (dto == null)
            throw new TaskException(Messages.NULL_SUB_TASK_DTO);

        this.id = dto.getId();
        this.description = dto.getDescription();
        this.done = dto.getDone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubTask)) return false;
        SubTask subTask = (SubTask) o;
        return Objects.equals(id, subTask.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }

}

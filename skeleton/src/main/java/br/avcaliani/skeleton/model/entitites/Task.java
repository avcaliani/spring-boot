package br.avcaliani.skeleton.model.entitites;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.model.dtos.TaskDTO;
import br.avcaliani.skeleton.utils.Messages;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(indexes = {
        @Index(name = "description_index", columnList = "description")
})
@Data
public class Task {

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
    private List<SubTask> subTasks;

    /**
     * Default Constructor.
     */
    public Task() {

    }

    /**
     * DTO Converter Constructor.
     * @param dto Task DTO.
     */
    public Task(TaskDTO dto) throws TaskException {

        if (dto == null)
            throw new TaskException(Messages.NULL_TASK_DTO);

        this.id = dto.getId();
        this.owner = dto.getOwner();
        this.description = dto.getDescription();
        this.ready = dto.getReady();

        if (dto.getSubTasks() != null && !dto.getSubTasks().isEmpty()) {
            this.subTasks = new ArrayList<>();
            dto.getSubTasks().forEach(
                    subTask -> this.subTasks.add(new SubTask(subTask)
            ));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                ", ready=" + ready +
                '}';
    }
}

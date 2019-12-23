package br.avcaliani.skeleton.model.entity;

import br.avcaliani.skeleton.exception.TaskException;
import br.avcaliani.skeleton.model.dto.TaskDTO;
import br.avcaliani.skeleton.util.Messages;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(indexes = {
        @Index(name = "description_index", columnList = "description")
})
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {

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
     * DTO Converter Constructor.
     *
     * @param dto Task DTO.
     */
    public Task(TaskDTO dto) {

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

}

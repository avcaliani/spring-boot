package br.avcaliani.skeleton.service;

import br.avcaliani.skeleton.exception.TaskException;
import br.avcaliani.skeleton.model.dto.SubTaskDTO;
import br.avcaliani.skeleton.model.dto.TaskDTO;
import br.avcaliani.skeleton.model.entity.Task;
import br.avcaliani.skeleton.repository.TaskRepository;
import br.avcaliani.skeleton.util.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public TaskDTO save(TaskDTO task) {
        this.validate(task);
        return new TaskDTO(this.repository.save(new Task(task)));
    }

    @Override
    public TaskDTO update(TaskDTO task) {

        this.validate(task);
        if (task.getId() == null)
            throw new TaskException(Messages.TASK_ID_IS_NULL);

        return new TaskDTO(this.repository.save(new Task(task)));
    }

    @Override
    public List<TaskDTO> findAll() {
        return this.map(this.repository.findAll());
    }

    @Override
    public TaskDTO findOne(Long id) {
        if (id == null)
            throw new TaskException(Messages.TASK_ID_IS_NULL);
        return new TaskDTO(this.repository.getOne(id));
    }

    @Override
    public Boolean remove(Long id) {

        if (id == null)
            return false;

        this.repository.delete(new Task(this.findOne(id)));
        return true;
    }

    @Override
    public List<TaskDTO> findByReady(Boolean ready) {
        if (ready == null)
            throw new TaskException(Messages.NULL_PARAM);
        return this.map(this.repository.findByReady(ready));
    }

    @Override
    public List<TaskDTO> findByDescriptionLike(String value) {
        if (value == null)
            throw new TaskException(Messages.NULL_PARAM);
        return this.map(this.repository.findByDescriptionLike(value));
    }

    private List<TaskDTO> map(List<Task> tasks) {

        if (tasks == null || tasks.isEmpty())
            return new ArrayList<>();

        List<TaskDTO> dtos = new ArrayList<>();
        tasks.forEach(task -> dtos.add(new TaskDTO(task)));
        return dtos;
    }

    private void validate(TaskDTO task) {

        if (task == null)
            throw new TaskException(Messages.NULL_TASK);

        if (task.getReady() == null)
            task.setReady(false);

        if (task.getDescription() == null)
            throw new TaskException(Messages.TASK_DESCRIPTION_IS_NULL);

        if (task.getOwner() == null)
            throw new TaskException(Messages.TASK_OWNER_IS_NULL);

        List<SubTaskDTO> subTasks = task.getSubTasks();
        if (subTasks != null && !subTasks.isEmpty())
            subTasks.forEach(subTask -> {
                if (subTask == null)
                    throw new TaskException(Messages.SUB_TASK_IS_NULL);

                if (subTask.getDescription() == null)
                    throw new TaskException(Messages.SUB_TASK_DESCRIPTION_IS_NULL);

                if (subTask.getDone() == null)
                    subTask.setDone(false);
            });
    }
}

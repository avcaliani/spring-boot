package br.avcaliani.skeleton.services.impl;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.model.dtos.TaskDTO;
import br.avcaliani.skeleton.model.entitites.Task;
import br.avcaliani.skeleton.repositories.TaskRepository;
import br.avcaliani.skeleton.services.TaskService;
import br.avcaliani.skeleton.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: CREATE TEST
@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger L;

    static {
        L = Logger.getLogger(TaskServiceImpl.class.getSimpleName());
    }

    @Autowired
    private TaskRepository repository;

    @Override
    public TaskDTO save(TaskDTO task) throws TaskException {
        this.validate(task);
        return new TaskDTO(this.repository.save(new Task(task)));
    }

    @Override
    public TaskDTO update(TaskDTO task) throws TaskException {
        this.validate(task);

        if (task.getId() == null)
            throw new TaskException(Messages.TASK_ID_IS_NULL);

        return new TaskDTO(this.repository.save(new Task(task)));
    }

    @Override
    public List<TaskDTO> findAll() throws TaskException {
        return this.map(this.repository.findAll());
    }

    @Override
    public TaskDTO findOne(Long id) throws TaskException {
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
    public List<TaskDTO> findByReady(Boolean ready) throws TaskException {

        if (ready == null)
            throw new TaskException(Messages.NULL_PARAM);

        return this.map(this.repository.findByReady(ready));
    }

    @Override
    public List<TaskDTO> findByDescriptionLike(String value) throws TaskException {

        if (value == null)
            throw new TaskException(Messages.NULL_PARAM);

        return this.map(this.repository.findByDescriptionLike(value));
    }

    private List<TaskDTO> map(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty())
            return new ArrayList<>();

        var dtos = new ArrayList<TaskDTO>();
        tasks.forEach(task -> dtos.add(new TaskDTO(task)));
        return dtos;
    }

    private void validate(TaskDTO task) throws TaskException {

        if (task == null)
            throw new TaskException(Messages.NULL_TASK);

        if (task.getReady() == null)
            task.setReady(false);

        if (task.getDescription() == null)
            throw new TaskException(Messages.TASK_DESCRIPTION_IS_NULL);

        if (task.getOwner() == null)
            throw new TaskException(Messages.TASK_OWNER_IS_NULL);

        var subTasks = task.getSubTasks();
        if (subTasks != null || !subTasks.isEmpty())
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

package br.avcaliani.skeleton.services;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.models.entitites.TaskEntity;
import br.avcaliani.skeleton.models.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TaskService implements ITaskService {

    private static final Logger L;

    static {
        L = Logger.getLogger(TaskService.class.getSimpleName());
    }

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskEntity save(TaskEntity task) throws TaskException {

        if (task == null)
            throw new TaskException("Task Null!");

        try {
            return this.taskRepository.save(task);
        } catch (Exception ex){
            throw new TaskException("Error to Insert/Update Task.", ex);
        }
    }

    @Override
    public List<TaskEntity> findAll() throws TaskException {

        List<TaskEntity> tasks;

        try {
            tasks = this.taskRepository.findAll();

        } catch (Exception ex){
            throw new TaskException("Error to Find Tasks!", ex);
        }

        if (tasks == null || tasks.isEmpty()) {
            throw new TaskException("No Tasks Found!");
        }

        return tasks;
    }

    @Override
    public TaskEntity findOne(Long id) throws TaskException {
        if (id == null)
            throw new TaskException("Task Id Null!");

        try {
            return this.taskRepository.findOne(id);
        } catch (Exception ex){
            throw new TaskException("Error to Find Task by Id.", ex);
        }
    }

    @Override
    public Boolean remove(Long id) {

        if (id == null)
            return false;

        try {

            this.taskRepository.delete(id);
            return true;

        } catch (Exception ex){
            L.log(Level.SEVERE, "Error to delete Task!", ex);
        }

        return false;
    }

    @Override
    public List<TaskEntity> findByReady(Boolean ready) throws TaskException {

        if (ready == null)
            throw new TaskException("Null \"ready\" Param!");

        try {

            return this.taskRepository.findByReady(ready);

        } catch (Exception ex){
            throw new TaskException("Error to Find Tasks!", ex);
        }
    }

    @Override
    public List<TaskEntity> findByDescriptionLike(String value) throws TaskException {

        if (value == null)
            throw new TaskException("Null \"value\" Param!");

        try {

            return this.taskRepository.findByDescriptionLike(value);

        } catch (Exception ex){
            throw new TaskException("Error to Find Tasks!", ex);
        }
    }
}

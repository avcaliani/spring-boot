package br.avcaliani.skeleton.service;

import br.avcaliani.skeleton.model.entitites.TaskEntity;
import br.avcaliani.skeleton.model.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskEntity save(TaskEntity task) throws Exception {
        if (task == null)
            throw new Exception("Objeto nulo");

        try {
            return this.taskRepository.save(task);
        } catch (Exception ex){
            throw new Exception("Nao foi possivel inserir");
        }
    }

    @Override
    public List<TaskEntity> findAll() throws Exception {
        return null;
    }

    @Override
    public TaskEntity findOne(Long id) throws Exception {
        return null;
    }

    @Override
    public Boolean remove(Long id) {
        return null;
    }
}

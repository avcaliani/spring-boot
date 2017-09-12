package br.avcaliani.skeleton.service;

import br.avcaliani.skeleton.model.entitites.TaskEntity;

import java.util.List;

public interface ITaskService {

    /**
     *
     * @param task
     * @return
     * @throws Exception
     */
    public TaskEntity save(TaskEntity task) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    public List<TaskEntity> findAll() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public TaskEntity findOne(Long id) throws Exception;

    /**
     *
     * @param id
     * @return
     */
    public Boolean remove(Long id);

}

package br.avcaliani.skeleton.services;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.models.entitites.TaskEntity;

import java.util.List;

public interface ITaskService {

    /**
     * Save or Edit a Task.
     *
     * @param task Task.
     * @return Updated or Created Task.
     * @throws TaskException If Something wrong happen.
     */
    public TaskEntity save(TaskEntity task) throws TaskException;

    /**
     * Find all Tasks.
     *
     * @return List of Tasks.
     * @throws TaskException If Something wrong happen.
     */
    public List<TaskEntity> findAll() throws TaskException;

    /**
     * Find Task by Id.
     *
     * @param id Task Id.
     * @return Task found.
     * @throws TaskException If Something wrong happen.
     */
    public TaskEntity findOne(Long id) throws TaskException;

    /**
     * Remove Task.
     *
     * @param id Task Id.
     * @return true if Task has been removed or false otherwise.
     */
    public Boolean remove(Long id);

    /**
     * Find Tasks by Ready Status.
     *
     * @param ready Status.
     * @return List of Tasks
     * @throws TaskException If Something wrong happen.
     */
    public List<TaskEntity> findByReady(Boolean ready) throws TaskException;

    /**
     * Find Tasks looking for description like.
     *
     * @param value Part of Description.
     * @return List of Tasks
     * @throws TaskException If Something wrong happen.
     */
    public List<TaskEntity> findByDescriptionLike(String value) throws TaskException;

}

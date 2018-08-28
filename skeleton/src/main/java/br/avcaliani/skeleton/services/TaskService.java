package br.avcaliani.skeleton.services;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.model.dtos.TaskDTO;

import java.util.List;

public interface TaskService {

    /**
     * Save new Task.
     *
     * @param task Task.
     * @return Created Task.
     * @throws TaskException If Something wrong happen.
     */
    public TaskDTO save(TaskDTO task) throws TaskException;

    /**
     * Edit Task.
     *
     * @param task Task.
     * @return Updated Task.
     * @throws TaskException If Something wrong happen.
     */
    public TaskDTO update(TaskDTO task) throws TaskException;

    /**
     * Find all Tasks.
     *
     * @return List of Tasks.
     * @throws TaskException If Something wrong happen.
     */
    public List<TaskDTO> findAll() throws TaskException;

    /**
     * Find Task by Id.
     *
     * @param id Task Id.
     * @return Task found.
     * @throws TaskException If Something wrong happen.
     */
    public TaskDTO findOne(Long id) throws TaskException;

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
    public List<TaskDTO> findByReady(Boolean ready) throws TaskException;

    /**
     * Find Tasks looking for description like.
     *
     * @param value Part of Description.
     * @return List of Tasks
     * @throws TaskException If Something wrong happen.
     */
    public List<TaskDTO> findByDescriptionLike(String value) throws TaskException;

}

package br.avcaliani.skeleton.service;

import br.avcaliani.skeleton.exception.TaskException;
import br.avcaliani.skeleton.model.dto.TaskDTO;

import java.io.Serializable;
import java.util.List;

public interface TaskService extends Serializable {

    /**
     * Save new Task.
     *
     * @param task Task.
     * @return Created Task.
     * @throws TaskException If Something wrong happen.
     */
    TaskDTO save(TaskDTO task);

    /**
     * Edit Task.
     *
     * @param task Task.
     * @return Updated Task.
     * @throws TaskException If Something wrong happen.
     */
    TaskDTO update(TaskDTO task);

    /**
     * Find all Tasks.
     *
     * @return List of Tasks.
     * @throws TaskException If Something wrong happen.
     */
    List<TaskDTO> findAll();

    /**
     * Find Task by Id.
     *
     * @param id Task Id.
     * @return Task found.
     * @throws TaskException If Something wrong happen.
     */
    TaskDTO findOne(Long id);

    /**
     * Remove Task.
     *
     * @param id Task Id.
     * @return true if Task has been removed or false otherwise.
     */
    Boolean remove(Long id);

    /**
     * Find Tasks by Ready Status.
     *
     * @param ready Status.
     * @return List of Tasks
     * @throws TaskException If Something wrong happen.
     */
    List<TaskDTO> findByReady(Boolean ready);

    /**
     * Find Tasks looking for description like.
     *
     * @param value Part of Description.
     * @return List of Tasks
     * @throws TaskException If Something wrong happen.
     */
    List<TaskDTO> findByDescriptionLike(String value);

}

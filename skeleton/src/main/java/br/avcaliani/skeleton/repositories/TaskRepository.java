package br.avcaliani.skeleton.repositories;

import br.avcaliani.skeleton.model.entitites.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Even if I don't add some code here, I already have some methods like "findAll", "save", "findOne"...
 */
public interface TaskRepository extends JpaRepository <Task, Long>{

    /**
     * This will work without implementation only if method name follow this pattern:<br>
     * (findBy + ATTRIBUTE) for example: findByReady<br>
     * "Ready" is a Task Attribute.
     *
     * @param ready Task Status.
     * @return List of Tasks.
     */
    public List<Task> findByReady(@Param(value = "ready") Boolean ready);

    /**
     * Find Tasks looking for description like.
     *
     * @param value Part of Description.
     * @return List of Tasks
     */
    @Query(value = "select t from Task t where t.description like %:value%")
    public List<Task> findByDescriptionLike(@Param(value = "value") String value);

}

package br.avcaliani.skeleton.models.repositories;

import br.avcaliani.skeleton.models.entitites.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Even if I don't add code here, I already have some methods like "findAll", "save", "findOne"...
 */
public interface TaskRepository extends JpaRepository <TaskEntity, Long>{

    /**
     * This will work without implementation only if method name follow this pattern:<br>
     * (findBy + ATTRIBUTE) for example: findByReady<br>
     * "Ready" is a TaskEntity Attribute.
     *
     * @param ready Task Status.
     * @return List of Tasks.
     */
    public List<TaskEntity> findByReady(@Param(value = "ready") Boolean ready);

    /**
     * Find Tasks looking for description like.
     *
     * @param value Part of Description.
     * @return List of Tasks
     */
    @Query(value = "select t from task t where t.description like %:value%")
    public List<TaskEntity> findByDescriptionLike(@Param(value = "value") String value);

}

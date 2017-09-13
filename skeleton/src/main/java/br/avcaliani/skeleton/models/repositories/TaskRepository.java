package br.avcaliani.skeleton.models.repositories;

import br.avcaliani.skeleton.models.entitites.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Even if I don't add code here, I already have some methods like "findAll", "save", "findOne"...
 */
public interface TaskRepository extends JpaRepository <TaskEntity, Long>{

}

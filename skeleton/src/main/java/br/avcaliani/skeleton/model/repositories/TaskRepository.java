package br.avcaliani.skeleton.model.repositories;

import br.avcaliani.skeleton.model.entitites.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Mesmo sem adiconar nada aqui eu já ganho alguns métodos default.
 */
public interface TaskRepository extends JpaRepository <TaskEntity, Long>{


}

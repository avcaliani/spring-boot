package br.avcaliani.skeleton.services;

import br.avcaliani.skeleton.model.dtos.SubTaskDTO;
import br.avcaliani.skeleton.model.dtos.TaskDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TaskServiceTest {

    @Autowired
    private TaskService service;

    @Test
    public void createTaskTest() {

        var dto = new TaskDTO();
        dto.setOwner("JUnit User");
        dto.setDescription("JUnit Task");
        dto.setSubTasks(List.of(
                new SubTaskDTO("JUnit Sub-Task 1"),
                new SubTaskDTO("JUnit Sub-Task 2")
        ));

        dto = this.service.save(dto);
        Assert.assertNotNull("Null Task!", dto);
        Assert.assertNotNull("Null Task Id!", dto.getId());
        Assert.assertNotNull("Null Sub Task Id!", dto.getSubTasks().get(0).getId());
    }

}

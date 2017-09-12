package br.avcaliani.skeleton.controller;

import br.avcaliani.skeleton.model.entitites.TaskEntity;
import br.avcaliani.skeleton.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     *
     * @param task
     * @return
     */
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    @ResponseBody
    public TaskEntity save(@RequestBody TaskEntity task) {
        try {
            return this.taskService.save(task);
        } catch (Exception e) {
            return null;
        }
    }

}

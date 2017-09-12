package br.avcaliani.skeleton.controllers;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.models.entitites.TaskEntity;
import br.avcaliani.skeleton.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class TaskController {

    private static Logger L;

    static {
        L = Logger.getLogger(TaskController.class.getSimpleName());
    }

    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "/task", method = RequestMethod.GET)
    @ResponseBody
    public TaskEntity findAll() {
        return null;
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskEntity findById(@RequestParam(value = "id") Long id) {
        // Do I have to put this? -------------ˆ
        return null;
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    @ResponseBody
    public TaskEntity save(@RequestBody TaskEntity task) {
        
        try {
            return this.taskService.save(task);
        } catch (TaskException ex) {
            L.log(Level.SEVERE, "Error to Save Task!", ex);
        }

        return null;
    }

    @RequestMapping(value = "/task", method = RequestMethod.PUT)
    @ResponseBody
    public TaskEntity update(@RequestBody TaskEntity task) {
        return null;
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public TaskEntity remove(@RequestParam Long id) {
        return null;
    }

}

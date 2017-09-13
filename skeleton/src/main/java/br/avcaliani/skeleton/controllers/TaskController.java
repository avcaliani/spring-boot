package br.avcaliani.skeleton.controllers;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.models.entitites.TaskEntity;
import br.avcaliani.skeleton.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<TaskEntity> findAll() {

        try {
            return this.taskService.findAll();
        } catch (TaskException ex) {
            L.log(Level.SEVERE, "Error to Find All Tasks!", ex);
        }

        return null;
    }

    /**
     * Here is an Example of generic response for Success or Error.
     */
    /*@RequestMapping(value = "/task", method = RequestMethod.GET)
    @ResponseBody
    public ResponseJson findAll() {

        try {
            return new ResponseJson(this.taskService.findAll());
        } catch (TaskException ex) {
            L.log(Level.SEVERE, "Error to Find All Tasks!", ex);
            return new ResponseJson(ex);
        }
    }*/



    /**
     * If You want, you can throw exception "as response", you just have to declare "throws...".
     */
    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskEntity findById(@PathVariable(value = "id") Long id) throws TaskException {
        return this.taskService.findOne(id);
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

        try {
            return this.taskService.save(task);
        } catch (TaskException ex) {
            L.log(Level.SEVERE, "Error to Update Task!", ex);
        }

        return null;
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean remove(@PathVariable(value = "id") Long id) {
        return this.taskService.remove(id);
    }

}

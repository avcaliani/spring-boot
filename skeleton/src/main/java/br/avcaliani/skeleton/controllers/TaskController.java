package br.avcaliani.skeleton.controllers;

import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.models.entitites.TaskEntity;
import br.avcaliani.skeleton.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;


    //
    // Here is an Example of generic response for Success or Error.
    //
    //@RequestMapping(value = "/task", method = RequestMethod.GET)
    //@ResponseBody
    //public ResponseJson findAll() {
    //
    //    try {
    //        return new ResponseJson(this.taskService.findAll());
    //    } catch (TaskException ex) {
    //        return new ResponseJson(ex);
    //    }
    //}

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    @ResponseBody
    public List<TaskEntity> findAll() throws TaskException{
        return this.taskService.findAll();
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskEntity findById(@PathVariable(value = "id") Long id) throws TaskException {
        return this.taskService.findOne(id);
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    @ResponseBody
    public TaskEntity save(@RequestBody TaskEntity task) throws TaskException {
        return this.taskService.save(task);
    }

    @RequestMapping(value = "/task", method = RequestMethod.PUT)
    @ResponseBody
    public TaskEntity update(@RequestBody TaskEntity task) throws TaskException {
         return this.taskService.save(task);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean remove(@PathVariable(value = "id") Long id) {
        return this.taskService.remove(id);
    }

}

package br.avcaliani.skeleton.controllers;

import br.avcaliani.skeleton.controllers.utils.HandlerController;
import br.avcaliani.skeleton.controllers.utils.Response;
import br.avcaliani.skeleton.exceptions.TaskException;
import br.avcaliani.skeleton.model.dtos.TaskDTO;
import br.avcaliani.skeleton.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/task")
@CrossOrigin(allowedHeaders = "*")
public class TaskController extends HandlerController {

    @Autowired
    private TaskService service;

    // ResponseEntity is the "Spring Boot default template" and it will have my default template.
    // Actually it's not necessary, but I think it's a good idea.
    // @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<Response> get() throws TaskException {
        return ResponseEntity.ok(new Response(this.service.findAll()));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Response> get(@PathVariable("id") Long id) throws TaskException {
        return ResponseEntity.ok(new Response(this.service.findOne(id)));
    }

    @GetMapping("/description/{desc}")
    @ResponseBody
    public ResponseEntity<Response> get(@PathVariable("desc") String desc) throws TaskException {
        return ResponseEntity.ok(new Response(this.service.findByDescriptionLike(desc)));
    }

    @GetMapping("/ready")
    @ResponseBody
    public ResponseEntity<Response> getReady() throws TaskException {
        return ResponseEntity.ok(new Response(this.service.findByReady(true)));
    }

    @GetMapping("/ready/{bool}")
    @ResponseBody
    public ResponseEntity<Response> getReady(@PathVariable("bool") Boolean bool) throws TaskException {
        return ResponseEntity.ok(new Response(this.service.findByReady(bool)));
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Response> save(@RequestBody TaskDTO task, HttpServletRequest request) throws TaskException {
        /**
         * HttpServletRequest is optional and it can be defined in every method here.
         * In this object we have many data, like request header for example.
         */
        return ResponseEntity.ok(new Response(this.service.save(task)));
    }

    @PutMapping("/")
    @ResponseBody
    public ResponseEntity<Response> update(@RequestBody TaskDTO task) throws TaskException {
        return ResponseEntity.ok(new Response(this.service.update(task)));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Response> remove(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new Response(this.service.remove(id)));
    }

}

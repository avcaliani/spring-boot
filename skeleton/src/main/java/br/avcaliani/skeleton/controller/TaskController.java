package br.avcaliani.skeleton.controller;

import br.avcaliani.skeleton.handler.HandlerController;
import br.avcaliani.skeleton.handler.Response;
import br.avcaliani.skeleton.model.dto.TaskDTO;
import br.avcaliani.skeleton.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/task")
public class TaskController extends HandlerController {

    @Autowired
    private TaskService service;

    // ResponseEntity is the "Spring Boot default template" and it will have my default template.
    // Actually it's not necessary, but I think it's a good idea.
    // @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public ResponseEntity<Response> get() {
        return ResponseEntity.ok(new Response(this.service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new Response(this.service.findOne(id)));
    }

    @GetMapping("/description/{desc}")
    public ResponseEntity<Response> get(@PathVariable("desc") String desc) {
        return ResponseEntity.ok(new Response(this.service.findByDescriptionLike(desc)));
    }

    @GetMapping("/ready")
    public ResponseEntity<Response> getReady() {
        return ResponseEntity.ok(new Response(this.service.findByReady(true)));
    }

    @GetMapping("/ready/{bool}")
    public ResponseEntity<Response> getReady(@PathVariable("bool") Boolean bool) {
        return ResponseEntity.ok(new Response(this.service.findByReady(bool)));
    }

    @PostMapping("/")
    public ResponseEntity<Response> save(@RequestBody TaskDTO task, HttpServletRequest request) {
        /**
         * HttpServletRequest is optional and it can be defined in every method here.
         * In this object we have many data, like request header for example.
         */
        return ResponseEntity.ok(new Response(this.service.save(task)));
    }

    @PutMapping("/")
    public ResponseEntity<Response> update(@RequestBody TaskDTO task) {
        return ResponseEntity.ok(new Response(this.service.update(task)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> remove(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new Response(this.service.remove(id)));
    }

}

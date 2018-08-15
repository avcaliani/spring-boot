package br.avcaliani.spec.controllers;

import br.avcaliani.spec.entities.Student;
import br.avcaliani.spec.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(allowedHeaders = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> find() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Student find(@PathVariable Long id) throws Exception {
        return this.service.find(id);
    }

}

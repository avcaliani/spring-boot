package br.avcaliani.specification.app.controller;

import br.avcaliani.specification.app.model.Student;
import br.avcaliani.specification.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> find() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Student find(@PathVariable Long id) {
        return this.service.find(id);
    }

    @GetMapping("/search")
    public Student find(@RequestParam("email") String email, @RequestParam("passport") String passport) {
        return this.service.findByEmailOrPassport(email, passport);
    }

}

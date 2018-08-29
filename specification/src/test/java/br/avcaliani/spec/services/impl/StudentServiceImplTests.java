package br.avcaliani.spec.services.impl;

import br.avcaliani.spec.services.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTests {

    @Autowired
    private StudentService service;

    @Test
    public void findStudentByEmailOrPassport() {
        var student = this.service.findByEmailOrPassport("anthony@github.com", "A123456");
        System.out.println(student);
        Assert.assertNotNull(student);
    }

    @Test
    public void failToFindStudentByEmailOrPassport() {
        var student = this.service.findByEmailOrPassport(null, null);
        Assert.assertNull(student);
    }

}

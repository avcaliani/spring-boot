package br.avcaliani.secureskeleton.user.controllers;

import br.avcaliani.secureskeleton.user.model.entities.User;
import br.avcaliani.secureskeleton.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/sign-up")
    public User signUp(@RequestBody User user) throws Exception {
        return this.userService.save(user);
    }

}

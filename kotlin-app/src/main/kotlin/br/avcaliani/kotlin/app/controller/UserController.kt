package br.avcaliani.kotlin.app.controller

import br.avcaliani.kotlin.app.model.User
import br.avcaliani.kotlin.app.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var service: UserService

    @GetMapping
    fun find(): List<User> = service.find()

    @GetMapping("/{id}")
    fun find(@PathVariable id: String): User = service.find(id)

    @PostMapping
    fun add(@RequestBody user: User): User = service.save(user)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: String): Unit = service.remove(id)

}
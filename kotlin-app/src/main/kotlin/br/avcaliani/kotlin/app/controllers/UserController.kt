package br.avcaliani.kotlin.app.controllers

import br.avcaliani.kotlin.app.models.User
import br.avcaliani.kotlin.app.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var service: UserService

    @GetMapping
    fun find(): List<User> = service.find()

    @GetMapping("/{id}")
    fun findByEmail(@PathVariable id: String): User = service.find(id)

    @PostMapping
    fun add(@RequestBody user: User): User = service.save(user)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: String): Unit = service.remove(id)

}
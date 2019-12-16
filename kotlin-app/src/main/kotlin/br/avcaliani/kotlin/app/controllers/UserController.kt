package br.avcaliani.kotlin.app.controllers

import br.avcaliani.kotlin.app.models.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping
    fun find(): List<User> = listOf(User("", "", ""))

    @GetMapping("/:id")
    fun find(@PathVariable id: String): User = User("0", "root", "root@root.com")

    @PostMapping
    fun add(@RequestBody user: User): User = user

    @PutMapping
    fun update(@RequestBody user: User): User = user

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: String): User = User("0", "root", "root@root.com")

}
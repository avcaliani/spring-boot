package br.avcaliani.kotlin.app.service

import br.avcaliani.kotlin.app.model.User
import br.avcaliani.kotlin.app.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {

    @Autowired
    private lateinit var repository: UserRepository

    fun find(): List<User> = repository.findAll().toList()

    fun find(id: String): User = repository.find(id) ?: throw RuntimeException("User not found!")

    fun remove(id: String) = repository.deleteById(id)

    fun save(user: User): User {

        if (user.name.trim().isEmpty())
            throw RuntimeException("User 'email' must be defined!")

        if (user.email.trim().isEmpty())
            throw RuntimeException("User 'email' must be defined!")

        return repository.save(User(UUID.randomUUID().toString(), user.name, user.email))
    }

}
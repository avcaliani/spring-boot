package br.avcaliani.kotlin.app.repositories

import br.avcaliani.kotlin.app.models.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, String> {

    @Query("select u from User u where u.id=:id")
    fun find(@Param("id") id: String): User?
}
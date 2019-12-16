package br.avcaliani.kotlin.app.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User(
    @Id
    val id: String? = null,
    @Column(nullable = false)
    val name: String = "",
    @Column(nullable = false, unique = true)
    val email: String = ""
)

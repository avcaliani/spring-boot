package br.avcaliani.kotlin.app.models

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User(
    @Id val id: String? = null,
    val name: String = "",
    val email: String = ""
)

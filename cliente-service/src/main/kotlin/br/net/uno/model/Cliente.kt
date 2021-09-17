package br.net.uno.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
data class Cliente(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Size(max = 50)
    val nome: String,

    @Size(min = 14)
    val documento: String,

    @Size(max = 50)
    val endereco: String

)

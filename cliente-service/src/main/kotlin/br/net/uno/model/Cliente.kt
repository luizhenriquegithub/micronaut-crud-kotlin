package br.net.uno.model

import javax.persistence.*
import javax.validation.constraints.Size

@Entity(name = "clientes")
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @field:Size(max = 50)
    val nome: String,

    @field:Size(max = 14)
    val documento: String,

    @field:Size(max = 50)
    val endereco: String

)

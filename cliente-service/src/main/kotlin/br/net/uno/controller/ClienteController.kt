package br.net.uno.controller

import br.net.uno.model.Cliente
import br.net.uno.repository.ClienteRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/v1/clientes")
class ClienteController(
    private val clienteRepository: ClienteRepository
) {

    @Post
    fun create(@Body cliente: Cliente) {
        clienteRepository.save(cliente)
    }

    @Get
    fun findAll(): List<Cliente> {
        return clienteRepository.findAll()
    }


}
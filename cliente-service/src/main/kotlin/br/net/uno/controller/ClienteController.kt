package br.net.uno.controller

import br.net.uno.model.Cliente
import br.net.uno.repository.ClienteRepository
import io.micronaut.http.annotation.*

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

    @Get("/{id}")
    fun findById(@PathVariable id: Long): Cliente {
        return clienteRepository.findById(id).get()
    }

    @Delete("/{id}")
    fun delete(@PathVariable id: Long) {
        clienteRepository.deleteById(id)
    }


}
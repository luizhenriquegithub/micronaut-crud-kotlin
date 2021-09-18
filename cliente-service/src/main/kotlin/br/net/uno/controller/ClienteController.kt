package br.net.uno.controller

import br.net.uno.model.Cliente
import br.net.uno.repository.ClienteRepository
import io.micronaut.http.annotation.*
import javax.transaction.Transactional

@Controller("/v1/clientes")
open class ClienteController(
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

    @Put("/{id}")
    @Transactional
    open fun update(@PathVariable id: Long, @Body cliente: Cliente) {
        val clienteDB = clienteRepository.findById(id).get()
        clienteDB.nome = cliente.nome
        clienteDB.documento = cliente.documento
        clienteDB.endereco = cliente.endereco
        clienteRepository.save(clienteDB)
    }



}
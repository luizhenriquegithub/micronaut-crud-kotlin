package br.net.uno.controller

import br.net.uno.model.Cliente
import br.net.uno.service.ClienteService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/v1/clientes")
class ClienteController(
    private val clienteService: ClienteService
) {

    @Post
    fun create(@Body cliente: Cliente): HttpResponse<Cliente> {
        val clienteDB = clienteService.create(cliente)
        return HttpResponse.created(clienteDB)
    }

    @Get
    fun findAll(): List<Cliente> {
        return clienteService.findAll()
    }

    @Get("/{id}")
    fun findById(@PathVariable id: Long): Cliente {
        return clienteService.findById(id)
    }

    @Delete("/{id}")
    fun delete(@PathVariable id: Long): HttpResponse<Unit> {
        clienteService.delete(id)
        return HttpResponse.noContent()
    }

    @Put("/{id}")
    fun update(@PathVariable id: Long, @Body cliente: Cliente) {
        clienteService.update(id, cliente)
    }


}
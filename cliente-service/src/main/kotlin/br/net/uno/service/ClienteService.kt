package br.net.uno.service

import br.net.uno.model.Cliente
import br.net.uno.repository.ClienteRepository
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class ClienteService(
    private val clienteRepository: ClienteRepository
) {

    fun create(cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    fun findAll(): List<Cliente> {
        return clienteRepository.findAll()
    }

    fun findById(id: Long): Cliente {
        return clienteRepository.findById(id).get()
    }

    fun delete(id: Long) {
        clienteRepository.deleteById(id)
    }

    @Transactional
    open fun update(id: Long, cliente: Cliente) {
        val clienteDB = clienteRepository.findById(id).get()
        clienteDB.nome = cliente.nome
        clienteDB.documento = cliente.documento
        clienteDB.endereco = cliente.endereco
        clienteRepository.save(clienteDB)
    }


}
package br.net.uno.service

import br.net.uno.exception.RegistroNaoEncontradoException
import br.net.uno.model.Cliente
import br.net.uno.repository.ClienteRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class ClienteService(
    private val clienteRepository: ClienteRepository
) {

    fun create(cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    fun findAll(nome: String?, pageable: Pageable): Page<Cliente> {
        val clientes = if (nome == null) {
            clienteRepository.findAll(pageable)
        } else {
            clienteRepository.findByNome(nome,pageable)
        }
        return clientes
    }

    fun findById(id: Long): Cliente {
        return clienteRepository.findById(id).orElseThrow{
            RegistroNaoEncontradoException("Registro não encontrado")
        }
    }

    fun delete(id: Long) {
        val clienteDB = findById(id)
        clienteRepository.delete(clienteDB)
    }

    @Transactional
    open fun update(id: Long, cliente: Cliente) {
        val clienteDB = findById(id)
        clienteDB.nome = cliente.nome
        clienteDB.documento = cliente.documento
        clienteDB.endereco = cliente.endereco
        clienteRepository.save(clienteDB)
    }

    fun listar(nome: String?): List<Cliente> {
        return clienteRepository.listaComImplementacao(nome)
    }

}
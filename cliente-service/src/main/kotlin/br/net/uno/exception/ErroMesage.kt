package br.net.uno.exception

import java.time.LocalDateTime

data class ErroMesage(
    val dataHora: String = LocalDateTime.now().toString(),
    val msg: String?
)

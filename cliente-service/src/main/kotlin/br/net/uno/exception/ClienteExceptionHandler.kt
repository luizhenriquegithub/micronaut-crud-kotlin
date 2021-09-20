package br.net.uno.exception

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Singleton
@Requires(classes = [RegistroNaoEncontradoException::class])
class ClienteExceptionHandler: ExceptionHandler<RegistroNaoEncontradoException, HttpResponse<*>>  {

    override fun handle(request: HttpRequest<*>?, exception: RegistroNaoEncontradoException?): HttpResponse<*> {
        var msgErro = ErroMesage(
            msg = exception?.message
        )
        return HttpResponse.notFound<ErroMesage>().body(msgErro)
    }

}
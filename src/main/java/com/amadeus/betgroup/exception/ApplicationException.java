package com.amadeus.betgroup.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/*
 * Esta clase permite enviar un exception producto de un error logico. De esta forma se evita que se propague el 500 Internal Server Error.
 * Se envia el código 422 el cual indica que han producion un errores semánticos (errores lógicos).
 *
 * Nota: Para que progague este exception es necesario registrar el paquete que contiene esta clase en el web.xml
 * <init-param>
 *   <param-name>jersey.config.server.provider.packages</param-name>
 *   <param-value>com.amadeus.betgroup.rest;com.amadeus.betgroup.exception</param-value>
 * </init-param>
 */
@Provider
public class ApplicationException extends RuntimeException implements ExceptionMapper<ApplicationException> {
    // Este constructor es necesario, si no está ocurre una exception.
    public ApplicationException( String messageCode ){
        super(messageCode);
    }

    public ApplicationException() {
        super();
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    @Override
    public Response toResponse(ApplicationException exception) {
        Throwable cause = exception.getCause();
        int status = 0;

        /* Descomentar y el validar Exception para retornar el status correspondiente.
        if (cause instanceof NoFeasibleSolutionException) {
            status = 452;
        }
        */

        return Response.status(status).entity(cause.getMessage()).type("text/plain").build();
    }
}


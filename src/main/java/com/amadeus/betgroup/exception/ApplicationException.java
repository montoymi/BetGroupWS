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
    public ApplicationException(String messageCode) {
        super(messageCode);
    }

    public ApplicationException() {
        super();
    }
    
    @Override
    public Response toResponse(ApplicationException exception) {
        int status = 0;
        String message = exception.getMessage();

        switch (message) {
            case "USR001":
                status = 422;
                break;
            case "USR002":
                status = 423;
                break;
            case "INS001":
                // El password de la polla es incorrecto.
                status = 424;
                break;
            case "CRE001":
                status = 425;
                break;
            case "CRE002":
                status = 426;
                break;
        }

        return Response.status(status).entity(message).type("text/plain").build();
    }
}

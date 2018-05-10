package com.amadeus.betgroup.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/*
 * Nota: Para que progague este exception es necesario registrar el paquete que contiene esta clase en el web.xml
 * <init-param>
 *   <param-name>jersey.config.server.provider.packages</param-name>
 *   <param-value>com.amadeus.betgroup.rest;com.amadeus.betgroup.exception</param-value>
 * </init-param>
 */
@Provider
public class ApplicationException extends RuntimeException implements ExceptionMapper<ApplicationException> {
    // Este constructor es necesario, si no está ocurre una exception.
    public ApplicationException() {
        super();
    }

    public ApplicationException(String messageCode) {
        super(messageCode);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    @Override
    public Response toResponse(ApplicationException exception) {
        int status = 422; // Unprocessable Entity. La solicitud está bien formada pero fue imposible seguirla debido a errores semánticos.
        String message = exception.getMessage();

        if (exception.getCause() != null) {
            int lastIndex = message.lastIndexOf("ERROR:");
            message = message.substring(lastIndex);
            // En este punto el mensaje es como este: ERROR: E0005
            message = message.split(":")[1].trim();
        }

        return Response.status(status).entity(message).type("text/plain").build();
    }
}

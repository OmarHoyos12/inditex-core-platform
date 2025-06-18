package com.inditex.coreplatform.infrastructure.rest.exception;

import com.inditex.coreplatform.domain.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Manejador global de excepciones para los controladores REST.
 *
 * <p>Este componente intercepta las excepciones lanzadas por los controladores y devuelve respuestas HTTP
 * adecuadas. Se definen métodos para manejar errores específicos como {@link PriceNotFoundException},
 * errores de conversión de tipos y cualquier otra excepción no controlada.</p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja la excepción {@link PriceNotFoundException} cuando no se encuentra un precio válido.
     *
     * @param ex      La excepción lanzada.
     * @param request La solicitud web asociada.
     * @return Un {@link ResponseEntity} con detalles del error y el estado HTTP 404 (Not Found).
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePriceNotFound(PriceNotFoundException ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja la excepción {@link MethodArgumentTypeMismatchException} cuando los parámetros recibidos tienen tipos incorrectos.
     *
     * @param ex      La excepción lanzada.
     * @param request La solicitud web asociada.
     * @return Un {@link ResponseEntity} con detalles del error y el estado HTTP 400 (Bad Request).
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDetails> handleTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(new Date(), "Parámetros no válidos", request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja todas las demás excepciones que no se han capturado con un controlador específico.
     *
     * @param ex      La excepción lanzada.
     * @param request La solicitud web asociada.
     * @return Un {@link ResponseEntity} con detalles del error y el estado HTTP 500 (Internal Server Error).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalError(Exception ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


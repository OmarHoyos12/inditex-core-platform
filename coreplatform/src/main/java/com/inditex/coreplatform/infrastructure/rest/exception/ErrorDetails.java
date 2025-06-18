package com.inditex.coreplatform.infrastructure.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Objeto que encapsula los detalles de un error para ser retornados en las respuestas REST.
 *
 * <p>Contiene la marca de tiempo, un mensaje descriptivo y detalles adicionales sobre el error.</p>
 */
@Data
@AllArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}


// coreplatform/src/main/java/com/inditex/coreplatform/infrastructure/rest/exception/ErrorDetails.java
package com.inditex.coreplatform.infrastructure.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Modelo para la respuesta de error en formato JSON.
 */
@Data
@AllArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}

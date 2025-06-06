// coreplatform/src/main/java/com/inditex/coreplatform/infrastructure/rest/exception/ErrorDetails.java
package com.inditex.coreplatform.infrastructure.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor             // <— Esto genera el constructor (Date, String, String)
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}

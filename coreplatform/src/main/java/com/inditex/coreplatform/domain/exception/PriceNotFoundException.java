// coreplatform/src/main/java/com/inditex/coreplatform/domain/exception/PriceNotFoundException.java
package com.inditex.coreplatform.domain.exception;

/**
 * Excepción que se lanza cuando no se encuentra precio válido.
 */
public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String message) {
        super(message);
    }
}

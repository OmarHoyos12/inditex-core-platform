package com.inditex.coreplatform.domain.exception;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un precio válido para los parámetros indicados.
 *
 * <p>Extiende de {@link RuntimeException}, permitiendo indicar de forma clara que una consulta
 * de precio no ha retornado resultados válidos.</p>
 */
public class PriceNotFoundException extends RuntimeException {

    /**
     * Construye una nueva instancia de {@code PriceNotFoundException} con el mensaje especificado.
     *
     * @param message Mensaje descriptivo del error.
     */
    public PriceNotFoundException(String message) {
        super(message);
    }
}


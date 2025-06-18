package com.inditex.coreplatform.application.service;

import com.inditex.coreplatform.domain.model.Price;
import java.time.LocalDateTime;

/**
 * Obtiene el precio aplicable de un producto.
 *
 * <p>Este servicio se encarga de determinar el precio vigente para un producto dado un identificador,
 * una marca y una fecha específica.</p>
 */
public interface PriceService {

    /**
     * Obtiene el precio aplicable para el producto y la marca indicados en una fecha determinada.
     *
     * @param productId       Identificador del producto.
     * @param brandId         Identificador de la marca.
     * @param applicationDate Fecha en la que se consulta el precio.
     */
    Price getApplicablePrice(Long productId, Integer brandId, LocalDateTime applicationDate);
}

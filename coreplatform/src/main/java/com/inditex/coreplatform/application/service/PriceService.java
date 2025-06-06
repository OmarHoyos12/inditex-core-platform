// coreplatform/src/main/java/com/inditex/coreplatform/application/service/PriceService.java
package com.inditex.coreplatform.application.service;

import com.inditex.coreplatform.domain.model.Price;
import java.time.LocalDateTime;

/**
 * Puerto de aplicación: define el caso de uso de obtener precio aplicable.
 */
public interface PriceService {
    /**
     * Obtiene el precio aplicable para un productId, brandId y fecha dada.
     * Si no existe, lanza PriceNotFoundException.
     */
    Price getApplicablePrice(Long productId, Integer brandId, LocalDateTime applicationDate);
}

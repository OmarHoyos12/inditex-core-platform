// coreplatform/src/main/java/com/inditex/coreplatform/domain/repository/PriceRepositoryPort.java
package com.inditex.coreplatform.domain.repository;

import com.inditex.coreplatform.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Puerto de salida para consultar precios en la base de datos.
 */
public interface PriceRepositoryPort {

    /**
     * Devuelve el precio válido con mayor prioridad (si existe) para un productId, brandId y fecha dada.
     */
    Optional<Price> findTopByProductIdAndBrandIdAndDate(Long productId, Integer brandId, LocalDateTime applicationDate);
}

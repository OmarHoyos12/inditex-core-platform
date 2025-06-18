package com.inditex.coreplatform.domain.repository;

import com.inditex.coreplatform.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Puerto de salida para la consulta de precios en la base de datos.
 *
 * <p>Define la interfaz que deben implementar los adaptadores de persistencia para recuperar
 * la información de precios, desacoplando la lógica del dominio de la tecnología de acceso a datos.</p>
 */
public interface PriceRepositoryPort {

    /**
     * Devuelve el precio válido con mayor prioridad para un producto, marca y fecha específicos.
     *
     * @param productId       Identificador del producto.
     * @param brandId         Identificador de la marca.
     * @param applicationDate Fecha en la que se evalúa la vigencia del precio.
     */
    Optional<Price> findTopByProductIdAndBrandIdAndDate(Long productId, Integer brandId, LocalDateTime applicationDate);
}


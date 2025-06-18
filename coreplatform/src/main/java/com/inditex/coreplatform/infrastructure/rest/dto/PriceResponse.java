package com.inditex.coreplatform.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO que representa la respuesta JSON del endpoint para consultar el precio aplicable.
 *
 * <p>Contiene la información del precio, incluyendo los identificadores del producto y la marca,
 * la lista de precio, el rango de vigencia, el valor y la moneda.</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceResponse {
    private Long productId;
    private Integer brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
}

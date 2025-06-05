// coreplatform/src/main/java/com/inditex/coreplatform/infrastructure/rest/dto/PriceResponse.java
package com.inditex.coreplatform.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO que representa la respuesta JSON del endpoint GET /api/v1/prices.
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
    private String currency;
}

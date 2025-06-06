// coreplatform/src/main/java/com/inditex/coreplatform/domain/model/Price.java
package com.inditex.coreplatform.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad de dominio Price (sin anotaciones JPA).
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Long productId;
    private Integer priority;
    private BigDecimal price;
    private String currency;
}

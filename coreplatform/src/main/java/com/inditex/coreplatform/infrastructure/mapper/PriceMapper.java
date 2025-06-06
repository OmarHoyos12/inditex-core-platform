// coreplatform/src/main/java/com/inditex/coreplatform/infrastructure/mapper/PriceMapper.java
package com.inditex.coreplatform.infrastructure.mapper;

import com.inditex.coreplatform.domain.model.Price;
import com.inditex.coreplatform.infrastructure.persistence.entity.PriceEntity;

/**
 * Convierte entre PriceEntity (JPA) y Price (dominio).
 */
public class PriceMapper {

    public static Price toDomain(PriceEntity entity) {
        if (entity == null) {
            return null;
        }
        return Price.builder()
                .brandId(entity.getBrandId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceList(entity.getPriceList())
                .productId(entity.getProductId())
                .priority(entity.getPriority())
                .price(entity.getPrice())
                .currency(entity.getCurrency())
                .build();
    }

    public static PriceEntity toEntity(Price domain) {
        if (domain == null) {
            return null;
        }
        return PriceEntity.builder()
                .brandId(domain.getBrandId())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .priceList(domain.getPriceList())
                .productId(domain.getProductId())
                .priority(domain.getPriority())
                .price(domain.getPrice())
                .currency(domain.getCurrency())
                .build();
    }
}

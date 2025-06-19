package com.inditex.coreplatform.infrastructure.mapper;

import com.inditex.coreplatform.domain.model.Price;
import com.inditex.coreplatform.infrastructure.persistence.entity.PriceEntity;

/**
 * Realiza la conversión entre la entidad JPA {@link PriceEntity} y la entidad de dominio {@link Price}.
 *
 * <p>Proporciona métodos de mapeo bidireccionales para transformar datos entre la capa de persistencia y la capa
 * de dominio.</p>
 */
public class PriceMapper {

    /**
     * Convierte una instancia de {@link PriceEntity} en una instancia de {@link Price}.
     *
     * @param entity Objeto {@link PriceEntity} a convertir.
     */
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

    /**
     * Convierte una instancia de {@link Price} en una instancia de {@link PriceEntity}.
     *
     * @param domain Objeto {@link Price} a convertir.
     * @return Una instancia de {@link PriceEntity} equivalente, o {@code null} si el dominio es nulo.
     */
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


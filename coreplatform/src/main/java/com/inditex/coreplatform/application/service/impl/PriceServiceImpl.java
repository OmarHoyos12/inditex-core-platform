// coreplatform/src/main/java/com/inditex/coreplatform/application/service/impl/PriceServiceImpl.java
package com.inditex.coreplatform.application.service.impl;

import com.inditex.coreplatform.application.service.PriceService;
import com.inditex.coreplatform.domain.exception.PriceNotFoundException;
import com.inditex.coreplatform.domain.model.Price;
import com.inditex.coreplatform.domain.repository.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Implementación del caso de uso de obtener precio.
 */
@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepositoryPort priceRepositoryPort;

    @Override
    public Price getApplicablePrice(Long productId, Integer brandId, LocalDateTime applicationDate) {
        return priceRepositoryPort
                .findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate)
                .orElseThrow(() -> new PriceNotFoundException(
                        String.format("No se encontró precio para productId=%d, brandId=%d, date=%s",
                                productId, brandId, applicationDate))
                );
    }
}

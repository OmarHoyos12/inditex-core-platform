// coreplatform/src/main/java/com/inditex/coreplatform/infrastructure/persistence/adapter/PriceRepositoryAdapter.java
package com.inditex.coreplatform.infrastructure.persistence.adapter;

import com.inditex.coreplatform.domain.model.Price;
import com.inditex.coreplatform.domain.repository.PriceRepositoryPort;
import com.inditex.coreplatform.infrastructure.mapper.PriceMapper;
import com.inditex.coreplatform.infrastructure.persistence.entity.PriceEntity;
import com.inditex.coreplatform.infrastructure.persistence.jpa.SpringDataPriceEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Adaptador que implementa el puerto PriceRepositoryPort usando Spring Data JPA.
 */
@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final SpringDataPriceEntityRepository jpaRepository;

    @Override
    public Optional<Price> findTopByProductIdAndBrandIdAndDate(Long productId,
                                                               Integer brandId,
                                                               LocalDateTime applicationDate) {
        Optional<PriceEntity> maybeEntity =
                jpaRepository.findTopEntityByProductIdAndBrandIdAndDate(productId, brandId, applicationDate);

        return maybeEntity.map(PriceMapper::toDomain);
    }
}

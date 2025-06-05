// coreplatform/src/main/java/com/inditex/coreplatform/infrastructure/persistence/jpa/SpringDataPriceRepository.java
package com.inditex.coreplatform.infrastructure.persistence.jpa;

import com.inditex.coreplatform.domain.model.Price;
import com.inditex.coreplatform.domain.repository.PriceRepositoryPort;
import com.inditex.coreplatform.infrastructure.persistence.entity.PriceEntity;
import com.inditex.coreplatform.infrastructure.mapper.PriceMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repositorio Spring Data JPA que implementa el puerto PriceRepositoryPort.
 */
@Repository
public interface SpringDataPriceRepository
        extends JpaRepository<PriceEntity, Long>, PriceRepositoryPort {

    /**
     * Consulta que devuelve el registro de mayor prioridad (Top 1) para un productId, brandId y fecha.
     */
    @Query("SELECT p FROM PriceEntity p " +
            "WHERE p.productId = :productId " +
            "  AND p.brandId = :brandId " +
            "  AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC, p.endDate DESC")
    Optional<PriceEntity> findTopByProductIdAndBrandIdAndDate(
            @Param("productId") Long productId,
            @Param("brandId") Integer brandId,
            @Param("applicationDate") LocalDateTime applicationDate
    );

    /**
     * Implementación del método del puerto de dominio, aplicando mapeo Entity → Domain.
     */
    @Override
    default Optional<Price> findTopByProductIdAndBrandIdAndDate(Long productId,
                                                                Integer brandId,
                                                                LocalDateTime applicationDate) {
        return findTopByProductIdAndBrandIdAndDate(applicationDate, productId, brandId)
                .map(PriceMapper::toDomain);
    }
}

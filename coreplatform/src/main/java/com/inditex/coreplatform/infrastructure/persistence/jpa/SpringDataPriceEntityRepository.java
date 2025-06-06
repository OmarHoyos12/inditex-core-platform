// coreplatform/src/main/java/com/inditex/coreplatform/infrastructure/persistence/jpa/SpringDataPriceEntityRepository.java
package com.inditex.coreplatform.infrastructure.persistence.jpa;

import com.inditex.coreplatform.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repositorio Spring Data JPA que maneja PriceEntity.
 */
@Repository
public interface SpringDataPriceEntityRepository extends JpaRepository<PriceEntity, Long> {

    /**
     * Consulta que devuelve el registro de mayor prioridad (Top 1) para un productId, brandId y fecha.
     */
    @Query("SELECT p FROM PriceEntity p " +
            "WHERE p.productId = :productId " +
            "  AND p.brandId = :brandId " +
            "  AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC, p.endDate DESC")
    Optional<PriceEntity> findTopEntityByProductIdAndBrandIdAndDate(
            @Param("productId") Long productId,
            @Param("brandId") Integer brandId,
            @Param("applicationDate") LocalDateTime applicationDate
    );
}

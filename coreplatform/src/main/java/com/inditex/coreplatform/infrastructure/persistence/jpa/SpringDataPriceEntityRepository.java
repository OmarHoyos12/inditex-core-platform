package com.inditex.coreplatform.infrastructure.persistence.jpa;

import com.inditex.coreplatform.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repositorio Spring Data JPA para la entidad {@link PriceEntity}.
 *
 * <p>Proporciona métodos de query derivation para recuperar registros de precios basados en criterios como
 * fechas de vigencia y prioridad, retornando el primer registro que cumple con dichos criterios.</p>
 */
@Repository
public interface SpringDataPriceEntityRepository extends JpaRepository<PriceEntity, Long> {

    /**
     * Encuentra el primer registro válido para producto y marca, cuya vigencia incluya las fechas indicadas,
     * y ordena el resultado por prioridad (descendente) y fecha de finalización (descendente).
     *
     * @param productId            Identificador del producto.
     * @param brandId              Identificador de la marca.
     * @param applicationDateStart Fecha límite inferior (inclusive) para la vigencia del precio.
     * @param applicationDateEnd   Fecha límite superior (inclusive) para la vigencia del precio.
     */
    Optional<PriceEntity> findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescEndDateDesc(
            Long productId,
            Integer brandId,
            LocalDateTime applicationDateStart,
            LocalDateTime applicationDateEnd
    );
}


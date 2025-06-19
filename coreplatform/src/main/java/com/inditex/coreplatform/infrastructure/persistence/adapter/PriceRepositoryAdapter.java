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
 * Adaptador que implementa el puerto {@link PriceRepositoryPort} utilizando Spring Data JPA.
 *
 * <p>Este componente utiliza {@link SpringDataPriceEntityRepository} para recuperar el registro de precio válido,
 * aplicando query derivation con ordenamiento y limitando el resultado al primer registro encontrado.</p>
 */
@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final SpringDataPriceEntityRepository jpaRepository;

    /**
     * Busca el primer registro válido para los parámetros indicados.
     *
     * @param productId       Identificador del producto.
     * @param brandId         Identificador de la marca.
     * @param applicationDate Fecha de consulta para validar la vigencia del precio.
     */
    @Override
    public Optional<Price> findTopByProductIdAndBrandIdAndDate(
            Long productId,
            Integer brandId,
            LocalDateTime applicationDate
    ) {
        Optional<PriceEntity> maybeEntity = jpaRepository
                .findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescEndDateDesc(
                        productId,
                        brandId,
                        applicationDate,
                        applicationDate
                );
        return maybeEntity.map(PriceMapper::toDomain);
    }
}

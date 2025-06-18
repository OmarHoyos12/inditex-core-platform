package com.inditex.coreplatform.infrastructure.persistence.jpa;

import com.inditex.coreplatform.infrastructure.persistence.entity.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Sql(scripts = "/data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class SpringDataPriceEntityRepositoryTest {

    @Autowired
    private SpringDataPriceEntityRepository repository;

    private PriceEntity basePrice, promoPrice;

    @Test
    void whenWithinPromoWindow_thenFindsPromoPrice() {
        LocalDateTime date = LocalDateTime.of(2020,6,14,16,0);

        Optional<PriceEntity> found = repository
                .findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescEndDateDesc(
                        35455L, 1, date, date
                );

        assertThat(found).isPresent();
        assertThat(found.get().getPriceList()).isEqualTo(2);
    }

    @Test
    void whenOutsidePromoWindow_thenFindsBasePrice() {
        LocalDateTime date = LocalDateTime.of(2020,6,14,21,0);

        Optional<PriceEntity> found = repository
                .findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescEndDateDesc(
                        35455L, 1, date, date
                );

        assertThat(found).isPresent();
        assertThat(found.get().getPriceList()).isEqualTo(1);
    }

    @Test
    void whenNoMatch_thenReturnsEmpty() {
        LocalDateTime date = LocalDateTime.of(2021,1,1,0,0);

        Optional<PriceEntity> found = repository
                .findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescEndDateDesc(
                        35455L, 1, date, date
                );

        assertThat(found).isEmpty();
    }

}


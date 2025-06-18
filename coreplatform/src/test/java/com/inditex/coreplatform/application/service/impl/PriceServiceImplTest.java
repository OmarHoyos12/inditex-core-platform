package com.inditex.coreplatform.application.service;

import com.inditex.coreplatform.application.service.impl.PriceServiceImpl;
import com.inditex.coreplatform.domain.exception.PriceNotFoundException;
import com.inditex.coreplatform.domain.model.Price;
import com.inditex.coreplatform.domain.repository.PriceRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PriceServiceImplTest {

    private PriceRepositoryPort repository;
    private PriceService service;

    @BeforeEach
    void setUp() {
        repository = mock(PriceRepositoryPort.class);
        service    = new PriceServiceImpl(repository);
    }

    @Test
    void whenRepositoryReturnsPrice_thenServiceReturnsThatPrice() {
        var date = LocalDateTime.of(2020,6,14,16,0);
        var sample = Price.builder()
                .brandId(1)
                .productId(35455L)
                .priceList(2)
                .startDate(LocalDateTime.of(2020,6,14,15,0))
                .endDate(LocalDateTime.of(2020,6,14,18,30))
                .priority(1)
                .price(new BigDecimal("25.45"))
                .currency("EUR")
                .build();

        when(repository.findTopByProductIdAndBrandIdAndDate(35455L,1,date))
                .thenReturn(Optional.of(sample));

        var result = service.getApplicablePrice(35455L, 1, date);

        assertNotNull(result);
        assertEquals(sample.getPrice(), result.getPrice());
        verify(repository, times(1))
                .findTopByProductIdAndBrandIdAndDate(35455L,1,date);
    }

    @Test
    void whenRepositoryReturnsEmpty_thenServiceThrows() {
        var date = LocalDateTime.of(2020,6,14,10,0);
        when(repository.findTopByProductIdAndBrandIdAndDate(35455L,1,date))
                .thenReturn(Optional.empty());

        assertThrows(PriceNotFoundException.class,
                () -> service.getApplicablePrice(35455L,1,date)
        );
        verify(repository, times(1))
                .findTopByProductIdAndBrandIdAndDate(35455L,1,date);
    }
}


// coreplatform/src/main/java/com/inditex/coreplatform/infrastructure/rest/controller/PriceController.java
package com.inditex.coreplatform.infrastructure.rest.controller;

import com.inditex.coreplatform.application.service.PriceService;
import com.inditex.coreplatform.domain.model.Price;
import com.inditex.coreplatform.infrastructure.rest.dto.PriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Controlador REST que expone el endpoint para obtener el precio aplicable.
 */
@RestController
@RequestMapping("/api/v1/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    /**
     * GET /api/v1/prices?productId=...&brandId=...&applicationDate=yyyy-MM-dd'T'HH:mm:ss
     */
    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Integer brandId,
            @RequestParam("applicationDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime applicationDate) {

        Price price = priceService.getApplicablePrice(productId, brandId, applicationDate);

        PriceResponse response = PriceResponse.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .currency(price.getCurrency())
                .build();

        return ResponseEntity.ok(response);
    }
}

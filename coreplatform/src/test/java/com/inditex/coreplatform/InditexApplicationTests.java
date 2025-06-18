package com.inditex.coreplatform;

import com.inditex.coreplatform.application.service.PriceService;
import com.inditex.coreplatform.infrastructure.rest.controller.PriceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class InditexApplicationTests {

	@Autowired
	private PriceController priceController;

	@Autowired
	private PriceService priceService;

	@Test
	void contextLoads() {
		assertNotNull(priceController);
		assertNotNull(priceService);
	}
}


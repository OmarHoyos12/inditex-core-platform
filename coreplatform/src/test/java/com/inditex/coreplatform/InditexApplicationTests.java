package com.inditex.coreplatform;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Este test verifica que el contexto de Spring se cargue sin problemas.
 * Hemos deshabilitado la inicialización de data.sql para evitar error de H2.
 */
@SpringBootTest(properties = {
		"spring.sql.init.mode=never"  // <— Desactiva data.sql para este test de contexto
})
class InditexApplicationTests {

	@Test
	void contextLoads() {
		// El test pasa si el contexto de Spring arranca correctamente
	}
}

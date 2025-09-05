package pratocheio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pratocheio.exception.PratoCheioException;

class PratoCheioControllerTest {
	
	private PratoCheioController pcc;
	
	@BeforeEach
	void prepara() {
		this.pcc = new PratoCheioController();
	}
	
	@Test
	void testCadastraPratoCircular() {
		assertEquals(1, pcc.cadastrarPratoCircular(2.50, "estampa", 3));
	}
	
	@Test
	void testCadastraPratoTriangular() {
		assertEquals(1, pcc.cadastrarPratoTriangular(2.50, "estampa", 3, 10));
	}
	
	@Test
	void testCadastraPratoRetangular() {
		assertEquals(1, pcc.cadastrarPratoRetangular(2.50, "estampa", 6, 10));
	}
	
	@Test
	void testCadastraPratoPrecoNegativo() {
		try {
			
		} catch (PratoCheioException pce) {
			assertEquals("Preço negativo", pce.getMessage());
		}
	}

}

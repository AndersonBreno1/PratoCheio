package pratocheio.util;

import pratocheio.exception.PratoCheioException;

public class Validador {
	
	public static void validaParametro(String param) {
		if (param == null) throw new PratoCheioException("Parametro nulo.");
		if ("".equals(param)) throw new PratoCheioException("Parametro vazio.");
	}
	
	public static void validaParametro(double param) {
		if (param < 0) throw new PratoCheioException("Parametro negativo.");
		if (param == 0) throw new PratoCheioException("Parametro zerado.");
	}
	
	
}

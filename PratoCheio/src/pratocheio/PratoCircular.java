package pratocheio;

import pratocheio.util.Validador;

public class PratoCircular extends Prato {
	
	private double raio;

	public PratoCircular(double preco, String personalizacao, double raio) {
		super(preco, personalizacao);
		
		Validador.validaParametro(raio);
		
		this.raio = raio;
	}

	@Override
	public double calculaArea() {
		return Math.PI * (raio * raio);
	}
	
}
package pratocheio;

import pratocheio.util.Validador;

public class PratoTriangular extends Prato {

	private double base;
	private double altura;
	
	public PratoTriangular(double preco, String personalizacao, double base, double altura) {
		super(preco, personalizacao);
		
		Validador.validaParametro(base);
		Validador.validaParametro(altura);
		
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calculaArea() {
		return base * altura / 2;
	}
}
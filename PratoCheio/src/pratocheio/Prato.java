package pratocheio;

import java.util.Objects;

import pratocheio.util.Validador;

public abstract class Prato {
	
	protected double preco;
	private String personalizacao;
	
	public Prato(double preco, String personalizacao) {
		Validador.validaParametro(preco);
		Validador.validaParametro(personalizacao);
		
		this.preco = preco;
		this.personalizacao = personalizacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(personalizacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		return Objects.equals(personalizacao, other.personalizacao);
	}
	
	@Override
	public String toString() {
		return "Preço: " + preco +
				"\nPersonalização: " + personalizacao;
	}

	public void alteraPersonalizacao(String personalizacao) {
		Validador.validaParametro(personalizacao);
		
		this.personalizacao = personalizacao;
	}
	
	public double calculaPreco() {
		return this.preco + calculaArea() * 0.01;
	}
	
	public abstract double calculaArea();

	public boolean comparaPersonalizacao(String personalizacao) {
		Validador.validaParametro(personalizacao);
		
		return this.personalizacao.equals(personalizacao);
	}
}
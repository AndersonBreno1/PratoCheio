package pratocheio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pratocheio.exception.PratoCheioException;
import pratocheio.util.Validador;

public class PratoCheioController {
	
	private Map<Integer, Prato> pratos;

	public PratoCheioController() {
		this.pratos = new HashMap<>();
	}
	
	public int cadastrarPratoTriangular(double preco, String personalizacao, double base, double altura) {
		Validador.validaParametro(preco);
		Validador.validaParametro(personalizacao);
		Validador.validaParametro(base);
		Validador.validaParametro(altura);
		
		Prato prato = new PratoTriangular(preco, personalizacao, base, altura);
		
		validaPrato(prato);
		
		this.pratos.put(this.pratos.size(), prato);
		
		return this.pratos.size();
	}
	
	public int cadastrarPratoRetangular(double preco, String personalizacao, double base, double altura) {
		Validador.validaParametro(preco);
		Validador.validaParametro(personalizacao);
		Validador.validaParametro(base);
		Validador.validaParametro(altura);
		
		Prato prato = new PratoRetangular(preco, personalizacao, base, altura);
		
		validaPrato(prato);
		
		this.pratos.put(this.pratos.size(), prato);
		
		return this.pratos.size();
	}
	
	public int cadastrarPratoCircular(double preco, String personalizacao, double raio) {
		Validador.validaParametro(preco);
		Validador.validaParametro(personalizacao);
		Validador.validaParametro(raio);
		
		Prato prato = new PratoCircular(preco, personalizacao, raio);
		
		validaPrato(prato);
		
		this.pratos.put(this.pratos.size(), prato);
		
		return this.pratos.size();
	}
	
	public void removerPrato(int idPrato) {
		validaPrato(idPrato);
		
		this.pratos.remove(idPrato - 1);
	}
	
	public int contaPratos() {
		return this.pratos.size();
	}
	
	public String recuperaPratoComPersonalizacao(String personalizacao) {
		Validador.validaParametro(personalizacao);
		
		for (Prato p : this.pratos.values()) {
			if (p.comparaPersonalizacao(personalizacao)) {
				return p.toString();
			}
		}
		return "Não há pratos com essa personalização";
	}

	private void validaPrato(Prato prato) {
		for (Prato p : this.pratos.values()) {
			if (p.equals(prato)) throw new PratoCheioException("Prato já existe");
		}
	}
	
	public String[] listarPratos() {
		List<String> out = new ArrayList<>();
		
		for (Prato p : this.pratos.values()) {
			out.add(p.toString());
		}
		
		return emArray(out);
	}

	private String[] emArray(List<String> lista) {
		String[] out = new String[lista.size()];
		int idxOut = 0;
		
		for (String elem : lista) {
			out[idxOut++] = elem;
		}
		
		return out;
	}
	
	public void mudarPersonalizacao(int idPrato, String personalizacao) {
		Validador.validaParametro(personalizacao);
		
		validaPrato(idPrato);
		
		getPrato(idPrato).alteraPersonalizacao(personalizacao);
	}
	
	public double calculaPrecoPrato(int idPrato) {
		validaPrato(idPrato);
		
		return getPrato(idPrato).calculaPreco();
	}
	
	public double calculaPrecoTotal() {
		double out = 0;
		
		for (Prato p : this.pratos.values()) {
			out += p.calculaPreco();
		}
		
		return out;
	}

	private Prato getPrato(int idPrato) {
		return this.pratos.get(idPrato - 1);
	}

	private void validaPrato(int idPrato) {
		if (!temPrato(idPrato)) throw new PratoCheioException("Prato não existe.");
	}

	private boolean temPrato(int idPrato) {
		return this.pratos.containsKey(idPrato - 1);
	}
}
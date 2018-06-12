package lab;

public class Aposta {
	
	private String nome;
	private int valor;
	private String previsao;
	
	public Aposta(String nome, int valor, String previsao) {
		this.nome = nome;
		this.valor = valor;
		this.previsao = previsao;
	}
	
	public String toString() {
		return this.nome+" - "+this.valor+" - "+this.previsao;
	}
	
	public int getValor() {
		return this.valor;
	}
	
}

package lab;

public class Aposta {
	
	private String nome;
	private int valor;
	private String previsao;
	
	public Aposta(String nome, int valor, String previsao) {
		previsao = previsao.toUpperCase();
		previsao = previsao.trim();
		nome = nome.trim();
		if(nome.equals(null) || nome.equals(""))
			throw new NullPointerException("Nome do apostador invalido.");
		if(valor <= 0)
			throw new NullPointerException("Valor da aposta invalido.");
		if(!previsao.equals("VAI ACONTECER") && !previsao.equals("NAO VAI ACONTECER"))
			throw new NullPointerException("Previsao invalida.");
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
	
	public String getPrevisao() {
		return this.previsao;
	}
	
}

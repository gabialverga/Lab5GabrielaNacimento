package lab;
/**
 * Representação de uma aposta. Cada aposta possui o nome do apostador,
 * o valor apostado e a previsão da aposta.
 * 
 * @author Gabriela Alverga - 117210703
 */
public class Aposta {
	
	/**
	 * nome, nome do apostador.
	 * valor, valor que foi apostado em centavos.
	 * previsao, previsão da aposta feita.
	 */
	private String nome;
	private int valor;
	private String previsao;
	
	/**
	 * Constroi um aposta padrão a partir no nome, valor e previsão.
	 * @param nome, nome do apostador;
	 * @param valor, valor que foi apostado;
	 * @param previsao, previsão da aposta.
	 */
	public Aposta(String nome, int valor, String previsao) {
		previsao = previsao.toUpperCase().trim();
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
	
	/**
	 * Retorna uma String representando todos os dados da aposta.
	 * A representação segue o formato: "nome - valor - previsao"
	 * 
	 * @return String com os dados da aposta.
	 */
	public String toString() {
		return this.nome+" - "+this.valor+" - "+this.previsao;
	}
	
	/**
	 * Retorna o valor que foi apostado.
	 * @return um inteiro representando o valor da posta.
	 */
	public int getValor() {
		return this.valor;
	}
	
	/**
	 * Retorna a previsão da aposta.
	 * @return uma String com a previsão da aposta.
	 */
	public String getPrevisao() {
		return this.previsao;
	}
	
}

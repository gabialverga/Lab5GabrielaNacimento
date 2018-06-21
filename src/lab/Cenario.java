package lab;

import java.util.ArrayList;

/**
 * Representa��o de uma cen�rio de onde ser�o feita as apostas.
 * Cada cen�rio possui um estado, uma descri��o e as apostas feitas para ele.
 * 
 * @author Gabriela Alverga - 117210703
 */
public class Cenario {
	
	/**
	 * estado, estado do cen�rio, se esta em aberto ou finalizado (ocorrendo ou n�o).
	 * descricao, descri��o do que est� sendo apostado para ocorrer ou n�o.
	 * apostas, lista que possui todas as apostas feitas para esse cen�rio.
	 */
	private String estado;
	private String descricao;
	public ArrayList<Aposta> apostas;
	
	/**
	 * Constroi um cenario padr�o, a partir da descri��o feita.
	 * Cada cen�rio come�a com a lista de apostas vazia e com estado n�o finalizado.
	 * 
	 * @param descricao, descri��o do que esta sendo apostado.
	 */
	public Cenario(String descricao) {
		descricao = descricao.trim();
		if(descricao.equals("") || descricao.equals(null))
			throw new NullPointerException("Descricao invalida.");
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.apostas = new ArrayList<Aposta>();
	}
	
	/**
	 * Retorna uma String contendo o estado do cen�rio.
	 * 
	 * @return uma String com o estado do cen�rio.
	 */
	public String getEstado(){
		return this.estado;
	}
	
	/**
	 * Finaliza um cen�rio.
	 * 
	 * @param ocorreu, valor booleano que indica se o que foi descrito no cen�rio ocorreu ou n�o.
	 */
	public void finalizarCenario(boolean ocorreu) {
		if(!this.estado.equals("Nao finalizado"))
			throw new NullPointerException("Cenario finalizado.");
		if(ocorreu) {
			this.estado = "Finalizado (ocoreu)";
		}
		else {
			this.estado = "Finalizado (nao ocoreu)";
		}
	}
	
	/**
	 * Retorna o valor total arrecadado pela cenario de aposta.
	 * 
	 * @return valor inteiro que representa a soma de todas as apostas perdedoras.
	 */
	public int getLucroCenario() {
		if(this.estado.equals("Nao finalizado"))
			throw new NullPointerException("Cenario nao finalizado.");
		int caixa=0;
		for(Aposta a: this.apostas) {
			if(this.estado.equals("Finalizado (ocoreu)") && a.getPrevisao().equals("NAO VAI ACONTECER")) {
				caixa+=a.getValor();
			}
			if(this.estado.equals("Finalizado (nao ocoreu)") && a.getPrevisao().equals("VAI ACONTECER")) {
				caixa+=a.getValor();
			}
		}
		return caixa;
	}
	
	/**
	 * Retorna  uma representa��o em String dos dados do cen�rio.
	 * A representa��o segue o formato: "descricao - estado"
	 * 
	 * @return String com os dados do cenario.
	 */
	public String toString() {
		return this.descricao+" - "+this.estado;
	}
	
	/**
	 * Cadastra uma aposta no cenario.
	 * 
	 * @param apostador, nome do apostador.
	 * @param valor, valor apostado.
	 * @param previsao, previsao para o cenario.
	 */
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		if(!this.estado.equals("Nao finalizado"))
			throw new NullPointerException("Cenario finalizado.");
		this.apostas.add(new Aposta(apostador, valor, previsao));
	}
	
	/**
	 * Retorna o valor total de todas as apostas feitas nesse cenario.
	 * 
	 * @return Valor inteiro contendo a soma do valor de todas as apostas feitas no cen�rio.
	 */
	public int getValorTotalApostas() {
		int total = 0;
		for(Aposta a: this.apostas) {
			total+=a.getValor();
		}
		return total;
	}
	
	/**
	 * Retorna a quantidade de apostas feitas nesse cenario.
	 *
	 * @return Um valor que representa o n�mero de apostas feitas nesse cen�rio.
	 */
	public int getTotalDeApostas() {
		return this.apostas.size();
	}

	/**
	 * Retorna uma String contendo as informa��es de todas as apostas feitas naquele cen�rio.
	 * 
	 * @return Uma String contendo as info��oes de todas as apostas.
	 */
	public String exibeApostas() {
		String apostas="";
		for(Aposta a: this.apostas) {
			apostas+=a.toString()+"\n";
		}
		return apostas;
	}
	
}

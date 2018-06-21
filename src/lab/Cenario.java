package lab;

import java.util.ArrayList;

/**
 * Representação de uma cenário de onde serão feita as apostas.
 * Cada cenário possui um estado, uma descrição e as apostas feitas para ele.
 * 
 * @author Gabriela Alverga - 117210703
 */
public class Cenario {
	
	/**
	 * estado, estado do cenário, se esta em aberto ou finalizado (ocorrendo ou não).
	 * descricao, descrição do que está sendo apostado para ocorrer ou não.
	 * apostas, lista que possui todas as apostas feitas para esse cenário.
	 */
	private String estado;
	private String descricao;
	public ArrayList<Aposta> apostas;
	
	/**
	 * Constroi um cenario padrão, a partir da descrição feita.
	 * Cada cenário começa com a lista de apostas vazia e com estado não finalizado.
	 * 
	 * @param descricao, descrição do que esta sendo apostado.
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
	 * Retorna uma String contendo o estado do cenário.
	 * 
	 * @return uma String com o estado do cenário.
	 */
	public String getEstado(){
		return this.estado;
	}
	
	/**
	 * Finaliza um cenário.
	 * 
	 * @param ocorreu, valor booleano que indica se o que foi descrito no cenário ocorreu ou não.
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
	 * Retorna  uma representação em String dos dados do cenário.
	 * A representação segue o formato: "descricao - estado"
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
	 * @return Valor inteiro contendo a soma do valor de todas as apostas feitas no cenário.
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
	 * @return Um valor que representa o número de apostas feitas nesse cenário.
	 */
	public int getTotalDeApostas() {
		return this.apostas.size();
	}

	/**
	 * Retorna uma String contendo as informações de todas as apostas feitas naquele cenário.
	 * 
	 * @return Uma String contendo as infoçãoes de todas as apostas.
	 */
	public String exibeApostas() {
		String apostas="";
		for(Aposta a: this.apostas) {
			apostas+=a.toString()+"\n";
		}
		return apostas;
	}
	
}

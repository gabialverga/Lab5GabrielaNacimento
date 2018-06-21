package lab;

import java.util.ArrayList;

/**
 * Utilizado para fazer a comunica��o das funcionaliades do cenario.
 * 
 * @author Gabriela Alverga - 117210703
 */
public class CenarioController {
	
	/**
	 * cenarios, uma lista com todos os cenarios criados.
	 * caixa, caixa que guarda a valor taxado dos cenarios.
	 * taxa, porcentagem do lucro do cenarios que deve ser repassado para o caixa.
	 */
	public ArrayList<Cenario> cenarios;
	public int caixa;
	public double taxa;
	
	/**
	 * Cria um controlador para os cenarios. Inicializando a lisca com nenhum cenario,
	 * caixa vazio e taxa 0;
	 */
	public CenarioController() {
		this.cenarios = new ArrayList<Cenario>();
		this.caixa = 0;
		this.taxa = 0.0;
	}
	
	/**
	 * Inicializa os valores do caixa e da taxa.
	 * 
	 * @param caixa, valor inicial existente no caixa.
	 * @param taxa, porcentagem que deve ser retirada dos lucros do cenario para o caixa.
	 */
	public void inicializa(int caixa, double taxa) {
		if(caixa < 0 || taxa < 0.0)
			throw new NullPointerException("Valor invalido.");
		this.caixa = caixa;
		this.taxa = taxa;
	}
	
	/**
	 * Retorna o valor existente no caixa.
	 * 
	 * @return inteiro com o valor existente no caixa.
	 */
	public int getCaixa() {
		return this.caixa;
	}
	
	/**
	 * Cria um cenario no controller.
	 * @param descricao, descricao do cenario a ser criado.
	 * 
	 * @return um inteiro representando o numero do cenario.
	 */
	public int cadastrarCenario(String descricao) {
		this.cenarios.add(new Cenario(descricao));
		return this.cenarios.size();
	}
	
	/**
	 * Cria um cenario bonus no controller.
	 * @param descricao, descricao do cenario a ser criado.
	 * @param bonus, valor a ser adicionado ao que será dividido pelos vencedores.
	 * 
	 * @return um inteiro representando o numero do cenario.
	 */
	public int cadastrarCenario(String descricao,int bonus) {
		this.cenarios.add(new CenarioBonus(descricao,bonus));
		return this.cenarios.size();
	}
	
	/**
	 * Retorna uma representa��o em String de um determinado cenario.
	 * 
	 * @param cenario, cenario que se deseja obter informa��es.
	 * 
	 * @return Uma String contendo os dados do cenairo desejado.
	 */
	public String getCenario(int cenario) {
		if(cenario<1 || cenario>this.cenarios.size())
			throw new NullPointerException("Cenario invalido.");
		return cenario + " - " + this.cenarios.get(cenario-1).toString();
	}
	
	/**
	 * Retorna uma String com a representa��o de todos os cenario cadastrados.
	 * 
	 * @return Ums String contendo os dados de todos os cenario cadastrados.
	 */
	public String getCenarios() {
		String cenarios = "";
		for(int i=0;i<this.cenarios.size();i++) {
			cenarios+=(i+1)+" - "+this.cenarios.get(i).toString()+"\n";
		}
		return cenarios;
	}
	
	/**
	 * Cadastra um apostador em um cenario.
	 * @param cenario, cenario que o apostador deve ser cadastrado.
	 * @param apostador, nome do apostador a ser cadastrado.
	 * @param valor, valor da aposta feita.
	 * @param previsao, previsao do apostador para o cenario.
	 */
	public void cadastrarApostador(int cenario, String apostador, int valor, String previsao) {
		if(cenario<1 || cenario>this.cenarios.size())
			throw new NullPointerException("Cenario invalido.");
		this.cenarios.get(cenario-1).cadastrarAposta(apostador, valor, previsao);
	}
	
	/**
	 * Retorna o valor total das apostas feitas em um cenario.
	 * @param cenario, cenario que deseja ser consultado.
	 * 
	 * @return Um valor inteiro com o valor total das apostas feitas ate aquele momento no cenario.
	 */
	public int valorTotalDeApostas(int cenario) {
		if(cenario<1 || cenario>this.cenarios.size())
			throw new NullPointerException("Cenario invalido.");
		return this.cenarios.get(cenario-1).getValorTotalApostas();
	}
	
	/**
	 * Retorna a quantidade total de apostas feitas naquele cenario.
	 * @param cenario, cenario a ser consultato.
	 * 
	 * @return Um valor inteiro representando a quantidade total de apostas feitas naquele cenario.
	 */
	public int totalDeApostas(int cenario) {
		if(cenario<1 || cenario>this.cenarios.size())
			throw new NullPointerException("Cenario invalido.");
		return this.cenarios.get(cenario-1).getTotalDeApostas();
	}
	
	/**
	 * Retorna uma String representando todas as apostas de um cenario.
	 * @param cenario, cenario que deve ser consultato.
	 * 
	 * @return Uma String com as informa��es de todas as apostas feitas naquele cenario.
	 */
	public String exibeApostas(int cenario) {
		if(cenario<1 || cenario>this.cenarios.size())
			throw new NullPointerException("Cenario invalido.");
		return this.cenarios.get(cenario-1).exibeApostas();
	}
	
	/**
	 * Finaliza um cenario.
	 * 
	 * @param cenario, cenario que deve ser finalizado.
	 * @param ocorreu, booleano que indica se o cenario ocorreu ou n�o.
	 */
	public void fecharApostas(int cenario, boolean ocorreu) {
		if(cenario<1 || cenario>this.cenarios.size())
			throw new NullPointerException("Cenario invalido.");
		this.cenarios.get(cenario-1).finalizarCenario(ocorreu);
		this.caixa+=(this.cenarios.get(cenario-1).getLucroCenario()*taxa);
	}
	
	/**
	 * Valor a ser repassado para o caixa.
	 * @param cenario, cenario que deve ser recebido o valor.
	 * @return um valor inteiro representando o valor a ser repassado para o caixa.
	 */
	public int getCaixaCenario(int cenario) {
		if(cenario<1 || cenario>this.cenarios.size())
			throw new NullPointerException("Cenario invalido.");
		return (int)(this.cenarios.get(cenario-1).getLucroCenario()*taxa);
	}
	
	/**
	 * Valor a ser dividido pelos vencedores.
	 * @param cenario, cenario que deve ser recebido a valor a ser dividido.
	 * @return Um valor inteiro que representa o montante a ser dividido pelos vencedores.
	 */
	public int getRateioCenario(int cenario) {
		if(cenario<1 || cenario>this.cenarios.size())
			throw new NullPointerException("Cenario invalido.");
		return this.cenarios.get(cenario-1).getLucroCenario() - (int)(this.cenarios.get(cenario-1).getLucroCenario()*taxa);
	}
}

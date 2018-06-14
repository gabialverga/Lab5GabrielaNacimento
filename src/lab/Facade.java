package lab;

public class Facade {
	
	CenarioController c;
	
	public Facade() {
		this.c = new CenarioController();
	}
	
	public void inicializa(int caixa, double taxa) {
		this.c.inicializa(caixa, taxa);
	}
	
	public int getCaixa() {
		return this.c.getCaixa();
	}
	
	public int cadastrarCenario(String descricao) {
		return this.c.cadastrarCenario(descricao);
	}
	
	public String exibirCenario(int cenario) {
		return this.c.getCenario(cenario);
	}
	
	public String exibirCenarios() {
		return this.c.getCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.c.cadastrarApostador(cenario, apostador, valor, previsao);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return this.c.valorTotalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return this.c.exibeApostas(cenario);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.c.fecharApostas(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		return this.c.getCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario) {
		return this.c.getRateioCenario(cenario);
	}
	
	
}

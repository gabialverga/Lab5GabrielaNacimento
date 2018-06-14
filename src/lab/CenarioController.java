package lab;

import java.util.ArrayList;

public class CenarioController {
	
	public ArrayList<Cenario> cenarios;
	public int caixa;
	public double taxa;
	
	public CenarioController() {
		this.cenarios = new ArrayList<Cenario>();
		this.caixa = 0;
		this.taxa = 0.0;
	}
	
	public void inicializa(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
	}
	
	public int getCaixa() {
		return this.caixa;
	}
	
	public int cadastrarCenario(String descricao) {
		this.cenarios.add(new Cenario(descricao));
		return this.cenarios.size();
	}
	
	public String getCenario(int cenario) {
		return this.cenarios.get(cenario-1).toString();
	}
	
	public String getCenarios() {
		String cenarios = "";
		for(int i=0;i<this.cenarios.size();i++) {
			cenarios+=(i+1)+" - "+this.cenarios.get(i).toString()+"\n";
		}
		return cenarios;
	}
	
	public void cadastrarApostador(int cenario, String apostador, int valor, String previsao) {
		this.cenarios.get(cenario-1).cadastrarAposta(apostador, valor, previsao);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return this.cenarios.get(cenario-1).getValorTotalApostas();
	}
	
	public int totalDeApostas(int cenario) {
		return this.cenarios.get(cenario-1).getTotalDeApostas();
	}
	
	public String exibeApostas(int cenario) {
		return this.cenarios.get(cenario-1).exibeApostas();
	}
	
	public void fecharApostas(int cenario, boolean ocorreu) {
		this.cenarios.get(cenario-1).finalizarCenario(ocorreu);
	}

	public int getCaixaCenario(int cenario) {
		return this.cenarios.get(cenario-1).getCaixaCenarioFechado();
	}

	public int getRateioCenario(int cenario) {
		return this.cenarios.get(cenario-1).getRateioCenarioFechado();
	}
}

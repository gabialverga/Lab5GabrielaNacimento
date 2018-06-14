package lab;

import java.util.ArrayList;

public class CenarioController {
	
	public ArrayList<Cenario> cenarios;
	
	
	
	public CenarioController() {
		this.cenarios = new ArrayList<Cenario>();
	}
	
	public void inicializa(int cenario, int caixa, double taxa) {
		this.cenarios.get(cenario-1).setCaixa(caixa);
		this.cenarios.get(cenario-1).setTaxa(taxa);
	}
	
	public int getCaixa(int cenario) {
		return this.cenarios.get(cenario-1).getCaixa();
	}
	
	public int cadastrarCenario(String descricao) {
		this.cenarios.add(new Cenario(descricao));
		return this.cenarios.size();
	}
	
	public String exibirCenario(int cenario) {
		return this.cenarios.get(cenario-1).toString();
	}
	
	public String exibirCenarios() {
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
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.cenarios.get(cenario-1).finalizarCenario(ocorreu);
	}
}

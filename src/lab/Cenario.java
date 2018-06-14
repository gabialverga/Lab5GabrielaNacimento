package lab;

import java.util.ArrayList;

public class Cenario {
	
	private String estado;
	private String descricao;
	public ArrayList<Aposta> apostas;
	public int caixa,rateio;
	
	public Cenario(String descricao) {
		descricao = descricao.toUpperCase();
		if(!descricao.equals("VAI ACONTECER") && !descricao.equals("NAO VAI ACONTECER"))
			throw new NullPointerException("Descricao invalida.");
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.apostas = new ArrayList<Aposta>();
		this.caixa = 0;
		this.rateio = 0;
	}
	
	public void finalizarCenario(boolean ocorreu) {
		int caixa = 0,total=0;
		if(ocorreu) {
			this.estado = "Finalizado (ocoreu)";
			for(Aposta a: apostas) {
				if(!this.descricao.equals(a.getPrevisao())) {
					caixa+=a.getValor();
				}
				total+=a.getValor();
			}
		}
		else {
			this.estado = "Finalizado (nao ocoreu)";
			for(Aposta a: apostas) {
				if(this.descricao.equals(a.getPrevisao())) {
					caixa+=a.getValor();
				}
				total+=a.getValor();
			}
		}
		this.caixa = caixa;
		this.rateio = total-caixa;
	}
	
	public int getCaixaCenarioFechado() {
		return this.caixa;
	}
	
	public int getRateioCenarioFechado() {
		return this.rateio;
	}
	
	public String toString() {
		return this.descricao+" - "+this.estado;
	}
	
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		this.apostas.add(new Aposta(apostador, valor, previsao));
	}
	
	public int getValorTotalApostas() {
		return this.caixa + this.rateio;
	}
	
	public int getTotalDeApostas() {
		return this.apostas.size();
	}

	public String exibeApostas() {
		String apostas="";
		for(Aposta a: this.apostas) {
			apostas+=a.toString()+"\n";
		}
		return apostas;
	}
	
}

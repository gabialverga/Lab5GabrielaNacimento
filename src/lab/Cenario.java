package lab;

import java.util.ArrayList;

public class Cenario {
	
	private String estado;
	private String descricao;
	public ArrayList<Aposta> apostas;
	
	public Cenario(String descricao) {
		if(descricao.equals("") || descricao.equals(null))
			throw new NullPointerException("Descricao invalida.");
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.apostas = new ArrayList<Aposta>();
	}
	
	public void finalizarCenario(boolean ocorreu) {
		if(ocorreu) {
			this.estado = "Finalizado (ocoreu)";
		}
		else {
			this.estado = "Finalizado (nao ocoreu)";
		}
	}
	
	public int getCaixaCenarioFechado(double taxa) {
		if(this.estado.equals("Nao finalizado"))
			throw new NullPointerException("Cenario ainda nao finalizado.");
		int caixa=0;
		for(Aposta a: this.apostas) {
			if(this.estado.equals("Finalizado (ocoreu)") && a.getPrevisao().equals("NAO VAI ACONTECER")) {
				caixa+=a.getValor();
			}
			if(this.estado.equals("Finalizado (nao ocoreu)") && a.getPrevisao().equals("VAI ACONTECER")) {
				caixa+=a.getValor();
			}
		}
		return (int) (caixa*taxa);
	}
	
	public int getRateioCenarioFechado() {
		if(this.estado.equals("Nao finalizado"))
			throw new NullPointerException("Cenario ainda nao finalizado.");
		int caixa=0,total=0;
		for(Aposta a: this.apostas) {
			total+=a.getValor();
			if(this.estado.equals("Finalizado (ocoreu)") && a.getPrevisao().equals("NAO VAI ACONTECER")) {
				caixa+=a.getValor();
			}
			if(this.estado.equals("Finalizado (nao ocoreu)") && a.getPrevisao().equals("VAI ACONTECER")) {
				caixa+=a.getValor();
			}
		}
		return total;
	}
	
	public String toString() {
		return this.descricao+" - "+this.estado;
	}
	
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		if(this.estado.equals("Finalizado (nao ocoreu)") || this.estado.equals("Finalizado (nao ocoreu)"))
			throw new NullPointerException("Cenario finalizado.");
		this.apostas.add(new Aposta(apostador, valor, previsao));
	}
	
	public int getValorTotalApostas() {
		int total = 0;
		for(Aposta a: this.apostas) {
			total+=a.getValor();
		}
		return total;
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

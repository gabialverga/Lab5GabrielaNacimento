package lab;

import java.util.ArrayList;

public class Cenario {
	
	private String estado;
	private String descricao;
	public ArrayList<Aposta> apostas;
	public int caixa;
	public int dividido;
	public double taxa;
	
	public Cenario(String descricao) {
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.apostas = new ArrayList<Aposta>();
		this.caixa = 0;
		this.taxa = 0.0;
		this.dividido = 0;
	}
	
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	public void setCaixa(int caixa) {
		this.caixa = caixa;
	}
	
	public int getCaixa() {
		return this.caixa;
	}
	
	public void finalizarCenario(boolean ocorreu) {
		int soma = 0;
		if(ocorreu) {
			this.estado = "Finalizado (ocoreu)";
			for(Aposta a: apostas) {
				if(!this.descricao.equals(a.getPrevisao())) {
					soma+=a.getValor();
				}
			}
		}
		else {
			this.estado = "Finalizado (nao ocoreu)";
			for(Aposta a: apostas) {
				if(this.descricao.equals(a.getPrevisao())) {
					soma+=a.getValor();
				}
			}
		}
		this.caixa+=soma*this.taxa;
		this.dividido = (int) (soma - (soma*this.taxa));
	}
	
	public String toString() {
		return this.descricao+" - "+this.estado;
	}
	
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		this.apostas.add(new Aposta(apostador, valor, previsao));
	}
	
	public int getValorTotalApostas() {
		int total=0;
		for(Aposta a: apostas) {
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

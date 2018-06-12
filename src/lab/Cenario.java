package lab;

import java.util.ArrayList;

public class Cenario {
	
	private String estado;
	private String descricao;
	public ArrayList<Aposta> apostas;
	
	public Cenario(String descricao) {
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

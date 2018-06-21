package lab;

public class ApostaAsseguradaTaxa extends Aposta{

	public double taxa;
	public ApostaAsseguradaTaxa(String nome, int valor, String previsao,double taxa) {
		super(nome, valor, previsao);
		this.taxa = taxa;
	}

}

package lab;

public class ApostaAsseguradaValor extends Aposta{
	
	public int valor;
	
	public ApostaAsseguradaValor(String nome, int valorAposta, String previsao,int valorSeguro) {
		super(nome, valorAposta, previsao);
		this.valor = valorSeguro;
	}
}

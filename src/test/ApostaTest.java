package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab.Aposta;

public class ApostaTest {

	public Aposta aposta;
	
	@Before
	public void criaAposta() {
		aposta = new Aposta("Gabriela",100,"vai acontecer");
	}
	
	@Test (expected = NullPointerException.class)
	public void criaApostaNomeInvalido() {
		Aposta aposta = new Aposta("",100,"vai acontecer");
	}

	@Test (expected = NullPointerException.class)
	public void criaApostaNomeNulo() {
		Aposta aposta = new Aposta(null,100,"vai acontecer");
	}

	@Test (expected = NullPointerException.class)
	public void criaApostaValorInvalido() {
		Aposta aposta = new Aposta("Gabriela",-100,"vai acontecer");
	}
	
	@Test (expected = NullPointerException.class)
	public void criaApostaPrevisaoEmpate() {
		Aposta aposta = new Aposta("Gabriela",100,"empate");
	}
	
	@Test (expected = NullPointerException.class)
	public void criaApostaPrevisaoNula() {
		Aposta aposta = new Aposta("Gabriela",100,null);
	}
	
	@Test (expected = NullPointerException.class)
	public void criaApostaPrevisaoInvalida() {
		Aposta aposta = new Aposta("Gabriela",100,"");
	}
	
	@Test
	public void testToString() {
		String saida = "Gabriela - 100 - VAI ACONTECER";
		assertEquals(saida,aposta.toString());
	}
	
	@Test
	public void testGetPrevisao() {
		String saida = "VAI ACONTECER";
		assertEquals(saida,aposta.getPrevisao());
	}
	
	@Test
	public void testGetValor() {
		int saida = 100;
		assertEquals(saida,aposta.getValor());
	}
}

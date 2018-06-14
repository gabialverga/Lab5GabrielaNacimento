package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab.Aposta;
import lab.Cenario;

public class CenarioTest {
	
	public Cenario cenario;
	
	@Before
	public void criaCenario() {
		cenario = new Cenario("vai acontecer");
		cenario.cadastrarAposta("Gabriela",100,"vai acontecer");
		cenario.cadastrarAposta("Gabriela",50,"nao vai acontecer");
		cenario.finalizarCenario(true);
	}
	
	@Test (expected = NullPointerException.class)
	public void criaCenarioDescricaoInvalida() {
		cenario = new Cenario("");
	}
	
	@Test (expected = NullPointerException.class)
	public void criaCenarioDescricaoNula() {
		cenario = new Cenario(null);
	}
	
	@Test (expected = NullPointerException.class)
	public void criaCenarioDescricaoErrada() {
		cenario = new Cenario("empate");
	}
	
	@Test (expected = NullPointerException.class)
	public void cadastraApostaInvalida() {
		cenario.cadastrarAposta("",100,"vai acontecer");
	}
	
	@Test
	public void testeExibeApostas() {
		String saida ="Gabriela - 100 - VAI ACONTECER\nGabriela - 50 - NAO VAI ACONTECER\n";
		assertEquals(saida,cenario.exibeApostas());
	}	
}

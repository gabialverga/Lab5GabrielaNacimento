package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab.Aposta;
import lab.Cenario;

public class CenarioTest {
	
	public Cenario cenario01,cenario02,cenario03;
	
	@Before
	public void criaCenario() {
		cenario01 = new Cenario("Gabriela vai ser aprovada em LP2.");
		cenario01.cadastrarAposta("Gabriela",10,"vai acontecer");
		cenario01.cadastrarAposta("Gabriela",500,"nao vai acontecer");
		cenario01.finalizarCenario(true);
		
		cenario02 = new Cenario("Maria vai ganhar todas as partidas de poker hoje.");
		cenario02.cadastrarAposta("Gabriela",100,"vai acontecer");
		
		cenario03 = new Cenario("Gabriela vai ser aprovada em LP2.");
		cenario03.cadastrarAposta("Gabriela",10,"vai acontecer");
		cenario03.cadastrarAposta("Gabriela",500,"nao vai acontecer");
		cenario03.finalizarCenario(false);
	}
	
	@Test (expected = NullPointerException.class)
	public void criaCenarioDescricaoInvalida() {
		Cenario c = new Cenario("");
	}
	
	@Test (expected = NullPointerException.class)
	public void criaCenarioDescricaoNula() {
		Cenario cenario = new Cenario(null);
	}
	
	@Test
	public void testaGetEstadoFinalizado() {
		assertEquals("Finalizado (ocoreu)",cenario01.getEstado());
	}
	
	@Test
	public void testaGetEstadoNaoFinalizado() {
		assertEquals("Nao finalizado",cenario02.getEstado());
	}
	
	@Test
	public void testaGetEstadoFinalizadoNaoOcorreu() {
		assertEquals("Finalizado (nao ocoreu)",cenario03.getEstado());
	}
	
	@Test (expected = NullPointerException.class)
	public void testeFinalizarCenarioFinalizado() {
		cenario01.finalizarCenario(true);
	}
	
	@Test
	public void testeGetLucroCenarioFinalizado() {
		assertEquals(500,cenario01.getLucroCenario());
	}
	
	@Test (expected = NullPointerException.class)
	public void testeGetCaixaCenarioNaoFinalizado() {
		cenario02.getLucroCenario();
	}
	
	@Test
	public void testaToStringCenario01() {
		assertEquals("Gabriela vai ser aprovada em LP2. - Finalizado (ocoreu)",cenario01.toString());
	}
	
	@Test
	public void testaToStringCenario02() {
		assertEquals("Maria vai ganhar todas as partidas de poker hoje. - Nao finalizado",cenario02.toString());
	}
	
	@Test
	public void testaToStringCenario03() {
		assertEquals("Gabriela vai ser aprovada em LP2. - Finalizado (nao ocoreu)",cenario03.toString());
	}
	
	@Test (expected = NullPointerException.class)
	public void testeCadastraApostaCenarioFinalizado() {
		cenario01.cadastrarAposta("Gabi", 100, "vai acontecer");
	}
	
	@Test
	public void testeValorTotalApostasCenario01() {
		assertEquals(510,cenario01.getValorTotalApostas());
	}
	
	@Test
	public void testeValorTotalApostasCenario02() {
		assertEquals(100,cenario02.getValorTotalApostas());
	}
	
	@Test
	public void testeValorTotalApostasCenario03() {
		assertEquals(510,cenario03.getValorTotalApostas());
	}
	
	@Test
	public void testeTotalDeApostasCenario01() {
		assertEquals(2,cenario01.getTotalDeApostas());
	}
	
	@Test
	public void testeTotalDeApostasCenario02() {
		assertEquals(1,cenario02.getTotalDeApostas());
	}
	
	@Test
	public void testeTotalDeApostasCenario03() {
		assertEquals(2,cenario03.getTotalDeApostas());
	}
	
	@Test
	public void testeExibeCenario01() {
		assertEquals("Gabriela - 10 - VAI ACONTECER\nGabriela - 500 - NAO VAI ACONTECER\n",cenario01.exibeApostas());
	}
	@Test
	public void testeExibeCenario02() {
		assertEquals("Gabriela - 100 - VAI ACONTECER\n",cenario02.exibeApostas());
	}
	@Test
	public void testeExibeCenario03() {
		assertEquals("Gabriela - 10 - VAI ACONTECER\nGabriela - 500 - NAO VAI ACONTECER\n",cenario03.exibeApostas());
	}
}

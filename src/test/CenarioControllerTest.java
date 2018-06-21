package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab.Cenario;
import lab.CenarioController;

public class CenarioControllerTest {

	CenarioController cenarioController;
	
	@Before
	public void criaCenarioController() {
		cenarioController = new CenarioController();
		cenarioController.inicializa(0, 0.1);
	}
	
	@Test (expected = NullPointerException.class)
	public void inicializaCaixaInvalido() {
		cenarioController.inicializa(-1, 0.1);
	}
	
	@Test (expected = NullPointerException.class)
	public void inicializataxaInvalido() {
		cenarioController.inicializa(0, -0.1);
	}
	
	@Test
	public void testaGetCaixa() {
		assertEquals(0,cenarioController.getCaixa());
	}
	
	@Test
	public void testaCadastraCenario() {
		assertEquals(1,cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2."));
	}
	
	@Test (expected = NullPointerException.class)
	public void getCenarioInvalido() {
		cenarioController.getCenario(0);
	}
	
	@Test (expected = NullPointerException.class)
	public void getCenarioNaoCadastrado() {
		cenarioController.getCenario(6);
	}
	
	@Test
	public void testGetCenarios() {
		cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2.");
		assertEquals("1 - Gabriela vai ser aprovada em LP2. - Nao finalizado\n",cenarioController.getCenarios());
	}
	
	@Test (expected = NullPointerException.class)
	public void cadastraApostadorCenarioInvalido() {
		cenarioController.cadastrarApostador(-2, "Gabi", 10,"vai ACONTECER");
	}
	
	@Test (expected = NullPointerException.class)
	public void cadastraApostadorCenarioNaoCadastrado() {
		cenarioController.cadastrarApostador(9, "Gabi", 10,"vai ACONTECER");
	}
	
	@Test
	public void testValorTotalCenario() {
		cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2.");
		assertEquals(0,cenarioController.valorTotalDeApostas(1));
	}
	
	@Test (expected = NullPointerException.class)
	public void testValorTotalCenarioNaoCadastrado() {
		cenarioController.valorTotalDeApostas(7);
	}
	
	@Test (expected = NullPointerException.class)
	public void testValorTotalCenarioInvalido() {
		cenarioController.valorTotalDeApostas(-9);
	}
	
	@Test
	public void testTotalDeApostasCenario() {
		cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2.");
		assertEquals(0,cenarioController.totalDeApostas(1));
	}

	@Test (expected = NullPointerException.class)
	public void testTotalDeApostasCenarioNaoCadastrado() {
		cenarioController.totalDeApostas(7);
	}
	
	@Test (expected = NullPointerException.class)
	public void testTotalDeApostasCenarioInvalido() {
		cenarioController.totalDeApostas(-9);
	}
	
	@Test (expected = NullPointerException.class)
	public void testExibeApostasCenarioNaoCadastrado() {
		cenarioController.exibeApostas(7);
	}
	
	@Test (expected = NullPointerException.class)
	public void testExibeApostasCenarioInvalido() {
		cenarioController.exibeApostas(-9);
	}
	
	@Test
	public void testExibeApostasCenario() {
		cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2.");
		cenarioController.cadastrarApostador(1, "Gabi", 10,"vai ACONTECER");
		assertEquals("Gabi - 10 - VAI ACONTECER\n",cenarioController.exibeApostas(1));
	}
	
	@Test (expected = NullPointerException.class)
	public void testFecharApostasCenarioNaoCadastrado() {
		cenarioController.fecharApostas(1, true);
	}
	
	@Test (expected = NullPointerException.class)
	public void testFecharApostasCenarioInvalido() {
		cenarioController.fecharApostas(-87, true);
	}
	
	@Test (expected = NullPointerException.class)
	public void testFecharApostasCenarioJaFinalizado() {
		cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2.");
		cenarioController.fecharApostas(1, true);
		cenarioController.fecharApostas(1, false);
	}
	
	@Test (expected = NullPointerException.class)
	public void testGetCaixaCenarioNaoCadastrado() {
		cenarioController.getCaixaCenario(64);
	}
	
	@Test (expected = NullPointerException.class)
	public void testGetCaixaCenarioInvalido() {
		cenarioController.getCaixaCenario(0);
	}
	
	@Test (expected = NullPointerException.class)
	public void testGetCaixaCenarioNaoFinalizado() {
		cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2.");
		cenarioController.getCaixaCenario(1);
	}
	
	@Test
	public void testGetCaixaCenario() {
		cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2.");
		cenarioController.cadastrarApostador(1, "Gabi", 1000,"Vai acontecer");
		cenarioController.fecharApostas(1,false);
		assertEquals(100,cenarioController.getCaixaCenario(1));
	}
	
	//---------------
	@Test (expected = NullPointerException.class)
	public void testGetRateioCenarioNaoCadastrado() {
		cenarioController.getRateioCenario(64);
	}
	
	@Test (expected = NullPointerException.class)
	public void testGetRateioCenarioInvalido() {
		cenarioController.getRateioCenario(0);
	}
	
	@Test (expected = NullPointerException.class)
	public void testGetRateioCenarioNaoFinalizado() {
		cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2.");
		cenarioController.getRateioCenario(1);
	}
	
	@Test
	public void testGetRateioCenario() {
		cenarioController.cadastrarCenario("Gabriela vai ser aprovada em LP2.");
		cenarioController.cadastrarApostador(1, "Gabi", 1000,"Vai acontecer");
		cenarioController.fecharApostas(1,false);
		assertEquals(900,cenarioController.getRateioCenario(1));
	}
}

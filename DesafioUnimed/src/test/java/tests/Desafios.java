package tests;

import static org.junit.Assert.assertTrue;

import org.junit.*;

public class Desafios extends BaseTest {
	@Test
	public void desafio_1() throws Exception {
		dadoQueEstouNoSiteDaUnimed();
		quandoRealizoUmaBuscaPeloRioDeJaneiro();

		assertTrue(entaoOSistemaRetornaResultadoComCidadeEEspecialidade());
	}

	@Test
	public void desafio_2() throws Exception {
		dadoQueEstouNoSiteDaUnimed();
		quandoRealizoUmaBuscaPeloRioDeJaneiro();

		assertTrue(entaoOSistemaRetornaDaPaginaUmDoisETresQueACidadeDeSaoPauloNaoAparece());
	}

}

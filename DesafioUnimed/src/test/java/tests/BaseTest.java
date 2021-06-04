package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import PageObjects.GuiaMedicoPage;
import PageObjects.HomePage;
import Suporte.Web;

public class BaseTest {

	private WebDriver navegador;
	private HomePage homePage;
	private GuiaMedicoPage guiaMedicoPage;

	@Before
	public void setup() {
		navegador = Web.createChrome();
		homePage = new HomePage(navegador);
		guiaMedicoPage = new GuiaMedicoPage(navegador);
	}

	@After
	public void teardown() {
		navegador.quit();
	}

	protected void dadoQueEstouNoSiteDaUnimed() throws InterruptedException {
		homePage.navegarParaPagina();

	}

	protected void quandoRealizoUmaBuscaPeloRioDeJaneiro() throws Exception {
		Thread.sleep(3000);
		homePage.acionarGuiaMedico();
		guiaMedicoPage.informarCampoPesquisa("Rio de Janeiro");
		guiaMedicoPage.realizarPesquisa();
		Thread.sleep(5000);
		guiaMedicoPage.aceitarCookies();
	}

	protected boolean entaoOSistemaRetornaResultadoComCidadeEEspecialidade() throws Exception {
		Thread.sleep(5000);
		return guiaMedicoPage.validarDesafio_1();

	}

	protected boolean entaoOSistemaRetornaDaPaginaUmDoisETresQueACidadeDeSaoPauloNaoAparece() throws Exception {
		Thread.sleep(3000);
		return guiaMedicoPage.validarDesafio_2();
	}

}

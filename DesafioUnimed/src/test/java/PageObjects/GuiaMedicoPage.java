package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuiaMedicoPage {
	private WebDriver navegador;

	public GuiaMedicoPage(WebDriver navegador) {
		this.navegador = navegador;
	}

	public void informarCampoPesquisa(String mensagem) {
		navegador.findElement(By.xpath("//input[@id=\"react-select-2-input\"]")).sendKeys(mensagem);

	}

	public void realizarPesquisa() {
		navegador.findElement(By.xpath("//input[@id=\"react-select-2-input\"]")).sendKeys("\ue007");
	}

	public boolean validarDesafio_1() throws Exception {
		String cards = "//div[@class='row']/div[$INDEX]/div[@class='ProviderCard']";

		for (int n = 1; n <= 20; n++) {
			String especialidadexPath = cards.replace("$INDEX", String.valueOf(n))
					+ "//div[@class='ProviderSpecialties']";
			String cidadexPath = cards.replace("$INDEX", String.valueOf(n)) + "//a";

			try {
				navegador.findElement(By.xpath(especialidadexPath));
				String text = navegador.findElement(By.xpath(cidadexPath)).getText();

				if (!text.contains("Rio de Janeiro/RJ") || !text.contains("Rio de Janeiro"))
					return false;

			} catch (Exception e) {
				return false;
			}

		}
		return true;

	}

	public boolean validarDesafio_2() throws Exception {

		String cardsXpath = "//div[@class='row']/div[$INDEX]/div[@class='ProviderCard']";
		int page = 1;
		int cards = 20;
		while (page <= 3) {
			for (int n = 1; n <= cards; n++) {
				String cidadexPath = cardsXpath.replace("$INDEX", String.valueOf(n)) + "//a";

				try {
					String text = navegador.findElement(By.xpath(cidadexPath)).getText();

					if (text.contains("São Paulo"))
						throw new Exception("São Paulo Encontrado");

				} catch (Exception e) {
					throw e;
				}

			}
			page++;
			cards += 20;
			navegador.findElement(By.xpath("//button[text()=\"Ver mais resultados\"]")).click();
			Thread.sleep(5000);
		}
		return true;

	}

	public void aceitarCookies() {
		navegador.findElement(By.xpath("//button[@id=\"acceptCookie\"]")).click();
	}
}

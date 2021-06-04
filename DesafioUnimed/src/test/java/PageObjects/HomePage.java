package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver navegador;
	public HomePage(WebDriver navegador) {
		this.navegador = navegador;
	}

	public void navegarParaPagina() {
		navegador.get("https://www.unimed.coop.br/");
	}

	public void acionarGuiaMedico() {
		navegador.findElement(By.xpath("//a[contains(text(), 'Guia Médico')]")).click();
	}
}
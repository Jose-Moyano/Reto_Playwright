package com.orangehrmlive.steps;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.orangehrmlive.utils.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class RegisterSteps extends Base{
		
	@BeforeAll
	public static void SetUp() {
		playwright = Playwright.create();
	    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
	    page = browser.newPage();
	}
	
	@Dado("el usuario está logueado en la página {string}")
	public void el_usuario_está_logueado_en_la_página(String URLLogin) {
		page.navigate(URLLogin);
		page.type("input[name='username']", "Admin");
	    page.type("input[name='password']", "admin123");
	    page.locator("//button").click();
	    
		page.locator("(//li/a/span[@data-v-6475d26d])[2]").click();
		page.locator("//div[@class='orangehrm-header-container'] //button").click();
	}

	@Dado("el usuario está en la página de registro de nuevo empleado")
	public void el_usuario_está_en_la_página_de_registro_de_nuevo_empleado() {
	    //page2.locator("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']").click();
		//page2.locator("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]").click();
	}

		
	@Cuando("el usuario ingresa la información: {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void el_usuario_ingresa_la_información(String image, String FirstName, String MiddleName, String LastName, String EmploiId, String LoginDetails, String UserName, String Status, String Password, String RePass) {
		page.type("input[name='firstName']",FirstName);
		page.type("input[name='middleName']",MiddleName);
		page.type("input[name='lastName']",LastName);
		page.type("(//input[@class='oxd-input oxd-input--active'])[2]",EmploiId);
		page.locator("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']").click();
		page.type("(//div //input[@class='oxd-input oxd-input--active'])[3]",UserName);
		page.type("(//div //input[@type='password'])[1]",Password);
		page.type("(//div //input[@type='password'])[2]",RePass);
		//page.locator("//button[@type='submit']").click();
		
	}

	@Cuando("cuando el usuario hace clic en el botón Save")
	public void cuando_el_usuario_hace_clic_en_el_botón_save() {
		page.locator("//button[@type='submit']").click();
		
		
	}

	@Entonces("el nuevo empleado es registrado correctamente")
	public void el_nuevo_empleado_es_registrado_correctamente() {
		String titulo = page.locator("(//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'])[1]").textContent();
		System.out.println(titulo);
		assertEquals(titulo, "Add Employee");
	}
	
	
	@AfterAll
	public static void tearDown() {
		browser.close();
		playwright.close();
	}
	
	
}

package com.orangehrmlive.steps;


import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.orangehrmlive.utils.Base;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class LoginSteps extends Base {

	@BeforeAll
	public static void SetUp() {
		playwright = Playwright.create();
	    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
	    page = browser.newPage();
	}
		
	@Given("User is on LoginPage of OrangeHRM {string}")
	public void user_is_on_login_page_of_orange_hrm(String url) {
		page.navigate(url);
	}

	@When("User enters the required data {string} {string}")
	public void user_enters_the_required_data(String username, String password) {
		page.type("input[name='username']", username);
	    page.type("input[name='password']", password);
	    page.click("//button");
	}
	
	@Then("Is displayed the Dashboard Page")
	public void is_displayed_the_dashboard_page() {
		String titulo = page.locator("//span /h6").textContent();
		System.out.println(titulo);
		assertEquals(titulo, "Dashboard");
		
	}
	
	@AfterAll
	public static void tearDown() {
		browser.close();
		playwright.close();
	}
	
}

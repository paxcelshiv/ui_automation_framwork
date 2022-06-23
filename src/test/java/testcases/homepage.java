package testcases;

import static com.vangoghmuseum.utility.BrowserLuncher.browserhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.vangoghmuseum.assertions.Validator;
import com.vangoghmuseum.utility.BrowserLuncher;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class homepage {
	static List<String> orderdetail;

	@BeforeTest
	public void initLogger() {
		DOMConfigurator.configure("log4j.xml");
	}

	@Given("^I am on the Home page url \"([^\"]*)\"$")
	public void i_am_on_the_Home_page_url(String url) {
		BrowserLuncher.launchBrowser();
		browserhelper.enterUrl(url);
	}

	@When("^I Scroll right from home page$")
	public void i_Scroll_right_from_home_page() throws Throwable {
		browserhelper.click("Xpath", "//*[@id=\"vgm-app\"]/div/footer/div/section/div[2]/button[1]");
		browserhelper.click("Css", "#vgm-app > div > main > section > section > div > div > button:nth-child(4) > svg > use");
	}

	@When("^I Click on \"([^\"]*)\" link$")
	public void i_Click_on_link(String arg1) throws Throwable {
		browserhelper.click("Xpath", "//a[contains(@href,'/nl/collectie')]");
	}

	@Then("^I should verify page title as \"([^\"]*)\"$")
	public void i_should_verify_page_title_as(String pageTitle) throws Throwable {
		Validator.verify(pageTitle, browserhelper.getText("Xpath", "//h1[text()='Collectie']"));
	}

	@Then("^Verify placeholder \"([^\"]*)\" in search textbox$")
	public void verify_placeholder_in_search_textbox(String placeHolderStr) throws Throwable {
		browserhelper.verifyTextBox("Xpath", "//input[contains(@placeholder,'Zoek een kunstwerk')]");
	}
	
	@Then("^close browser for Home test cases$")
	public void close_browser_for_Home_test_cases() throws Throwable {
		browserhelper.quitebrowser();
	}

}

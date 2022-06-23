package testcases;

import static com.vangoghmuseum.utility.BrowserLuncher.browserhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeTest;

import com.vangoghmuseum.assertions.Validator;
import com.vangoghmuseum.utility.BrowserLuncher;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class collectiepage {
	static List<String> orderdetail;

	/*
	 * @BeforeTest public void initLogger() {
	 * DOMConfigurator.configure("log4j.xml"); }
	 */
	@Given("^I am opening url \"([^\"]*)\"$")
	public void i_am_opening_url(String url) throws Throwable {
		BrowserLuncher.launchBrowser();
		browserhelper.enterUrl(url);
	}

	@When("^I Scrolling right hand side$")
	public void i_Scrolling_right_hand_side() throws Throwable {
		browserhelper.click("Xpath", "//*[@id=\"vgm-app\"]/div/footer/div/section/div[2]/button[1]");
		browserhelper.click("Css", "#vgm-app > div > main > section > section > div > div > button:nth-child(4) > svg > use");
	}

	@When("^I Clicking on \"([^\"]*)\" textlink$")
	public void i_Clicking_on_textlink(String arg1) throws Throwable {
		browserhelper.click("Xpath", "//a[contains(@href,'/nl/collectie')]");
	}

	@When("^I Enter \"([^\"]*)\" text in Search textbox$")
	public void i_Enter_text_in_Search_textbox(String searchKey) throws Throwable {
		browserhelper.enterValueInTextbox(searchKey, "Xpath", "//input[contains(@placeholder,'Zoek een kunstwerk')]");
	}

	@When("^I Click on Search submit button$")
	public void i_Click_on_Search_submit_button() throws Throwable {
		browserhelper.click("Css", "#vgm-app > div:nth-child(1) > main > section > section.list-filters > div.grid-container.list-filters-form > div > div.list-filters-form-left > form > button > svg");
	}

	@Then("^Here should be appeared more than (\\d+) results$")
	public void here_should_be_appeared_more_than_results(int count) throws Throwable {
	   Validator.intVerify(count, browserhelper.getNumberCountfrombrowser("Css","#vgm-app > div:nth-child(1) > main > section > div.grid-container > p > span")); 
	}

	@When("^Reload collection page and Enter \"([^\"]*)\" text in Search textbox$")
	public void reload_collection_page_and_Enter_text_in_Search_textbox(String searchText) throws Throwable {
		browserhelper.refresh();
		browserhelper.enterValueInTextbox(searchText, "Xpath", "//input[contains(@placeholder,'Zoek een kunstwerk')]");
		browserhelper.click("Css", "#vgm-app > div:nth-child(1) > main > section > section.list-filters > div.grid-container.list-filters-form > div > div.list-filters-form-left > form > button > svg");
	}

	@When("^I Click on the first result$")
	public void i_Click_on_the_first_result() throws Throwable {
		browserhelper.click("Css", "#vgm-app > div:nth-child(1) > main > section > section:nth-child(4) > div > div > div.collection-art-object-list.columns-6 > div:nth-child(1) > a > div > div > div.collection-art-object-item-image-wrapper.object-fit-container.contain > picture > img");
	}

	@Then("^I should verify painting as below$")
	public void i_should_verify_painting_as_below(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    //throw new PendingException();
	}
	@Then("^quite browser$")
	public void quite_browser() throws Throwable {
		browserhelper.quitebrowser();
	}
}

package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPages;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonSD {

    AmazonPages amazon = new AmazonPages();

    @When("user goes to {string}")
    public void userGoesTo(String url) {

        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @Then("user checks page title contains {string}")
    public void userChecksPageTitleContains(String title) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }

    @Then("user checks if searchbox is enabled")
    public void userChecksIfSearchboxIsEnabled() {

        Assert.assertTrue(amazon.searchBox.isEnabled());
    }

    @And("user search {string}")
    public void userSearch(String keyword) {

        amazon.searchBox.sendKeys(keyword + Keys.ENTER);
    }

    @Then("user checks if results contains {string}")
    public void userChecksIfResultsContains(String keyword) {

        Assert.assertTrue(amazon.searchResult.getText().contains(keyword));
    }

    @Then("user closes browser")
    public void userClosesBrowser() {

        Driver.closeDriver();
    }
}
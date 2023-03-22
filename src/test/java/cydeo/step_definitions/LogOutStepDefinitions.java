package cydeo.step_definitions;

import cydeo.pages.LogIn;
import cydeo.pages.LogOut;
import cydeo.utilities.BrowserUtils;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogOutStepDefinitions {

    LogOut logout = new LogOut();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
    }

    @When("When the user clicks on the log out button")
    public void when_the_user_clicks_on_the_log_out_button() {
        logout.logoutBtn.click();

    }
    @Then("The user is redirected to the login page")
    public void the_user_is_redirected_to_the_login_page() {

        BrowserUtils.waitFor(10);
        String loginUrl = "https://qa.navfort.com/login";
        Assert.assertEquals(loginUrl, Driver.getDriver().getCurrentUrl());
    }

    @When("When the user clicks on the step back button")
    public void when_the_user_clicks_on_the_step_back_button() {
      Driver.getDriver().navigate().back();
    }
    @Then("The user should not be able to go back to the home page")
    public void the_user_should_not_be_able_to_go_back_to_the_home_page() {

        Assert.assertNotEquals("https://qa.navfort.com/", Driver.getDriver().getCurrentUrl());
    }

}

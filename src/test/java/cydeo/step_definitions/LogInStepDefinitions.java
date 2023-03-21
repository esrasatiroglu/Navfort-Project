package cydeo.step_definitions;

import cydeo.pages.LogIn;
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

public class LogInStepDefinitions {

    LogIn login = new LogIn();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
    }

    @When("The user logs in as a driver")
    public void the_user_logs_in_as_a_driver() {
        login.loginWithCredentials("user1", "UserUser123");
    }


    @Then("The user is on the Quick Launchpad page")
    public void the_user_is_on_the_quick_launchpad_page() {
        BrowserUtils.waitFor(3);
        String expectedResult = "Quick Launchpad";
        String actualResult = login.dashboard.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }


    @When("The user logs in as a sales manager")
    public void the_user_logs_in_as_a_sales_manager() {
        login.loginWithCredentials("storemanager51", "UserUser123");
    }


    @Then("The user is on the Dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        BrowserUtils.waitFor(3);
        String expectedResult = "Dashboard";
        String actualResult = login.dashboard.getText();
        Assert.assertEquals(expectedResult, actualResult);

    }

    @When("The user logs in as a store manager")
    public void the_user_logs_in_as_a_store_manager() {
        login.loginWithCredentials("salesmanager101", "UserUser123");
    }

    @When("The user enters an invalid username and valid password")
    public void the_user_enters_an_invalid_username_and_valid_password() {

        login.loginWithCredentials("user", "UserUser123");
    }

    @Then("The user gets {string} message")
    public void the_user_gets_message(String string) {
        String expectedError = "Invalid username or password.";
        String actualError = login.invalidUsernameOrPassword.getText();
        Assert.assertEquals(expectedError, actualError);

    }


    @When("The user enters a valid username and invalid password")
    public void the_user_enters_a_valid_username_and_invalid_password() {
        login.loginWithCredentials("user1", "User");

    }

    @When("The user enters an invalid username and invalid password")
    public void the_user_enters_an_invalid_username_and_invalid_password() {
        login.loginWithCredentials("user", "user1");
    }

    @When("The username is empty")
    public void the_username_is_empty() {
        login.loginWithCredentials("", "user2");

    }

    @Then("The user gets {string} message in the username field")
    public void the_user_gets_message_in_the_username_field(String string) {
        String actualPopUp = Driver.getDriver().findElement(By.name("_username")).getAttribute("validationMessage");
        String expectedPopUp = "Please fill in this field.";
        Assert.assertEquals(expectedPopUp, actualPopUp);
    }

    @When("The password field is empty")
    public void the_password_field_is_empty() {
        login.loginWithCredentials("user", "");
    }

    @Then("The user gets {string} message in the password field")
    public void the_user_gets_message_in_the_password_field(String string) {
        String actualPopUp = Driver.getDriver().findElement(By.name("_password")).getAttribute("validationMessage");
        String expectedPopUp = "Please fill in this field.";
        Assert.assertEquals(expectedPopUp, actualPopUp);
    }

    @When("both the username and password are empty")
    public void both_the_username_and_password_are_empty() {
        login.loginWithCredentials("","");
    }

    @Then("The user can see user1 in the profile menu, after login")
    public void the_user_can_see_user1_in_the_profile_menu_after_login() {

        BrowserUtils.waitForVisibility(login.accountName,10);
        String expectedUserName = login.accountName.getText();
        String actualUserName = "John Doe";
        Assert.assertEquals(expectedUserName, actualUserName);

    }

    @Then("The user can see storemanager51 in the profile menu, after login")
    public void the_user_can_see_storemanager51_in_the_profile_menu_after_login() {
        BrowserUtils.waitForVisibility(login.accountName,10);
        String expectedUserName = login.accountName.getText();
        String actualUserName = "John Doe";
        Assert.assertEquals(expectedUserName, actualUserName);
    }

    @Then("The user can see salesmanager101 in the profile menu, after login")
    public void the_user_can_see_salesmanager101_in_the_profile_menu_after_login() {
        BrowserUtils.waitForVisibility(login.accountName,10);
        String expectedUserName = login.accountName.getText();
        String actualUserName = "John Doe";
        Assert.assertEquals(expectedUserName, actualUserName);

    }}
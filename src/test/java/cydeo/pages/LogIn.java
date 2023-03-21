package cydeo.pages;

import cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {

    public LogIn() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "_username")
    public WebElement username;

    @FindBy(name = "_password")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement loginBtn;

    public void loginWithCredentials(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();

    }

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement dashboard;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidUsernameOrPassword;


    @FindBy(xpath = "//a[@href ='javascript: void(0);']")
    public WebElement accountName;
}

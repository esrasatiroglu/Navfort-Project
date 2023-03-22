package cydeo.pages;

import cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LogOut {

    public LogOut() {
        PageFactory.initElements(Driver.getDriver(), this);
}

    @FindBy(xpath = "//a[@href ='/user/logout']")
    public WebElement logoutBtn;

    @FindBy(xpath = "//button[@jsname='WiajEf'][1]")
    public WebElement backBtn;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement dashboard;

    @FindBy(xpath = "//a[@href ='javascript: void(0);']")
    public WebElement accountName;
}

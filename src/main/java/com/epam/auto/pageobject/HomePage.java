package com.epam.auto.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {

    WebDriver driver;
    @FindBy(xpath="\\xpath")
    WebElement button1;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}

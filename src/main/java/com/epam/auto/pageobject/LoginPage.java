package com.epam.auto.pageobject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //WebDriver driver;
    static WebDriver driver = null;
    @FindBy(xpath="\\xpath")
    WebElement button1;

    public static final String LOGIN = "input[value='Login']";
    public static final String SUCESSFUL_LOGIN = "//*[@id=\'content\']/h2[1]";
    public static final String INPUT_MAIL = "#input-email";
    public static final String INPUT_PASSWORD = "#input-password";
    public static final String ACCOUNT_TEXT = "My Account";
    NewUserInfo user = new NewUserInfo();

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        LoginPage.driver = driver;
    }

    public void loginWithNewAccount(){
        driver.findElement(By.cssSelector(INPUT_MAIL)).sendKeys(user.getEMAIL());
        driver.findElement(By.cssSelector(INPUT_PASSWORD)).sendKeys(user.getPASSWORD());
        driver.findElement(By.cssSelector(LOGIN)).click();

        //Asserting login with account
        Assertions.assertTrue(driver.findElement(By.xpath(SUCESSFUL_LOGIN)).getText().equals(ACCOUNT_TEXT));

    }



}

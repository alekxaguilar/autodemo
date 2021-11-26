package com.epam.auto.pageobject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.PortUnreachableException;
import java.security.SecureRandom;

public class HomePage {

    //WebDriver driver;
    static WebDriver driver = null;
    @FindBy(xpath="\\xpath")
    WebElement button1;

    public static final String MY_ACCOUNT = "//*[@id=\"top-links\"]/ul/li[2]/a";
    public static final String REGISTER = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a";
    public static final String LOGIN = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a";
    public static final String REGISTER_ACCOUNT = "div[id='content'] h1";
    public static final String REGISTER_ACCOUNT_TEXT = "Register Account";
    public static final String RETURNING_CUSTOMER = "//*[@id='content']/div/div[2]/div/h2";
    public static final String RETURNING_CUSTOMER_TEXT = "Returning Customer";


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        HomePage.driver = driver;
    }

    public void gettingRegisterPage(){
        driver.findElement(By.xpath(MY_ACCOUNT)).click();
        driver.findElement(By.xpath(REGISTER)).click();

        //Asserting the register page
        Assertions.assertTrue(driver.findElement(By.cssSelector(REGISTER_ACCOUNT)).getText().equals(REGISTER_ACCOUNT_TEXT));
    }

    public void loginAccount(){
        driver.findElement(By.xpath(MY_ACCOUNT)).click();
        driver.findElement(By.xpath(LOGIN)).click();

        //Asserting the login page
        Assertions.assertTrue(driver.findElement(By.xpath(RETURNING_CUSTOMER)).getText().equals(RETURNING_CUSTOMER_TEXT));
    }
}

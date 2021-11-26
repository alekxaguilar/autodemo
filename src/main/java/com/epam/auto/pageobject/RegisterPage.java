package com.epam.auto.pageobject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage {

    //WebDriver driver;
    static WebDriver driver = null;
    @FindBy(xpath="\\xpath")
    WebElement button1;

    private static final String NEWSLETTER = "input[value='1'][name='newsletter']";
    private static final String PRIVACY_POLICY = "input[value='1'][name='agree']";
    private static final String CONTINUE_CREATION = "input[value='Continue']";
    private static final String ACCOUNT_CREATED = "div[id='content'] h1";
    private static final String ACCOUNT_CREATED_MESSAGE = "Your Account Has Been Created!";
    private static final String CONTINUE = ".btn.btn-primary";
    private static final String INPUT_FIRSTNAME = "#input-firstname";
    private static final String INPUT_LASTNAME = "#input-lastname";
    private static final String INPUT_EMAIL = "#input-email";
    private static final String INPUT_TELEPHONE = "#input-telephone";
    private static final String INPUT_PASSWORD = "#input-password";
    private static final String INPUT_PASSWORD_CONFIRM = "#input-confirm";


    NewUserInfo user = new NewUserInfo();

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        RegisterPage.driver = driver;
    }

    public void accountInfo(){
        driver.findElement(By.cssSelector(INPUT_FIRSTNAME)).sendKeys(user.getFIRST_NAME());
        driver.findElement(By.cssSelector(INPUT_LASTNAME)).sendKeys(user.getLAST_NAME());
        driver.findElement(By.cssSelector(INPUT_EMAIL)).sendKeys(user.getEMAIL());
        driver.findElement(By.cssSelector(INPUT_TELEPHONE)).sendKeys(user.getTELEPHONE());
        driver.findElement(By.cssSelector(INPUT_PASSWORD)).sendKeys(user.getPASSWORD());
        driver.findElement(By.cssSelector(INPUT_PASSWORD_CONFIRM)).sendKeys(user.getPASSWORD());

        driver.findElement(By.cssSelector(NEWSLETTER)).click();
        driver.findElement(By.cssSelector(PRIVACY_POLICY)).click();
        driver.findElement(By.cssSelector(CONTINUE_CREATION)).click();

        //Asserting the register page
        Assertions.assertTrue(driver.findElement(By.cssSelector(ACCOUNT_CREATED)).getText().equals(ACCOUNT_CREATED_MESSAGE));
        driver.findElement(By.cssSelector(CONTINUE)).click();
    }


}

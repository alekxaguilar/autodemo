package com.epam.auto.test;

import com.epam.auto.pageobject.HomePage;
import com.epam.auto.pageobject.LoginPage;
import com.epam.auto.pageobject.PageRespository;
import com.epam.auto.pageobject.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1 {

    public static final int THREADSLEEP_TIME = 2000;
    public static final int IMPLICIT_TIME = 4;
    WebDriver driver;
    PageRespository pages = new PageRespository();

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }


    @AfterEach
    void teardown() {
       driver.quit();
    }


    /*@Test()
    void test() throws InterruptedException {
        driver.get("http://127.0.0.1:8080/");
        String title = driver.getTitle();
        // Verify
        assertThat(title).contains("Your Store");
        boolean logostatus = driver.findElement(new By.ById("logo")).isDisplayed();
        assertThat(logostatus).isTrue();
        driver.findElement(By.name("search")).sendKeys("iphone");
        driver.findElement(By.xpath("//div[@id='search']//button")).click();
        Thread.sleep(5000);
    }*/

    @Test()
    void getRegisterPage() throws InterruptedException {
        driver.get(pages.getHOME_PAGE());
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_TIME);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.gettingRegisterPage();

        Thread.sleep(THREADSLEEP_TIME);
    }

    @Test()
    void registerNewAccount() throws InterruptedException {
        driver.get(pages.getREGISTER_PAGE());
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_TIME);
        driver.manage().window().maximize();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.accountInfo();

        Thread.sleep(THREADSLEEP_TIME);
    }

    @Test()
    void loginNewAccount() throws InterruptedException {
        driver.get(pages.getLOGIN_PAGE());
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_TIME);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.loginAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithNewAccount();

        Thread.sleep(THREADSLEEP_TIME);
    }


}

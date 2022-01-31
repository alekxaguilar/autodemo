package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1 {

    WebDriver driver;

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

    @Test
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
    }
}

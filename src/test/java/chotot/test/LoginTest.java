package chotot.test;

import chotot.helpers.Drivers;
import chotot.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static WebDriver driver;
    public static LoginPage loginPage;

    String userPageUrl = "https://www.chotot.com/dashboard/ads";
    String loginUrl = "https://accounts.chotot.com/login?continue=https%3A%2F%2Fwww.chotot.com";
    String password = "testpassword";
    String phone = "0367273173";


    @Test
    public void userLogin() throws InterruptedException {
        driver.get(loginUrl);
        //login process
        loginPage.login(phone, password);
        //check after login
        driver.get(userPageUrl);
        Assert.assertEquals(userPageUrl, driver.getCurrentUrl());
    }


    @BeforeClass
    public static void setup() {
        driver = Drivers.getOSChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}

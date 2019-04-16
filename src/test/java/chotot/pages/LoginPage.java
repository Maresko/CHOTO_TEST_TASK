package chotot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"universal-main-container\"]/div[2]/div/div/div/form/input[1]") public WebElement phone_input;
    @FindBy(xpath = "//*[@id=\"universal-main-container\"]/div[2]/div/div/div/form/input[2]") public WebElement password_input;
    @FindBy(xpath = "//*[@id=\"universal-main-container\"]/div[2]/div/div/div/form/button[1]") public WebElement login_button;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String phone, String password){
        phone_input.sendKeys(phone);
        password_input.sendKeys(password);
        login_button.click();
    }
}

package com.orange_hrm.pages;

import com.github.dockerjava.core.DockerContextMetaFile;
import com.orange_hrm.drivers.DriverManager;
import com.orange_hrm.enums.Endpoints;
import com.orange_hrm.utils.ConfigReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @BeforeMethod
    @Step("Login in with username and password {0},{1}")
    public HomePage login(String userName, String password) {
        webElementActions.sendKeys(userNameInput, userName)
                .sendKeys(passwordInput, password)
                .click(loginBtn);

        return this;
    }

    private void chooseSidebarMenu(Endpoints endpoints) {
        WebElement element = DriverManager.getDriver().
                findElement(By.xpath("//ul[@class='oxd-main-menu']/li/a/span[text()='" + endpoints.getEndpoint() +"']"));
        element.click();
    }

}
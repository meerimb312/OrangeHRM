package com.orange_hrm.pages;

import com.orange_hrm.drivers.DriverManager;
import com.orange_hrm.helper.DropDownHelper;
import com.orange_hrm.helper.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver;
    protected WebDriverWait wait;
    public WebElementActions webElementActions = new WebElementActions();
    public DropDownHelper dropDownHelper = new DropDownHelper(DriverManager.getDriver());


    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected WebDriverWait getWait() {
        if (wait == null) {
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return wait;
    }
}

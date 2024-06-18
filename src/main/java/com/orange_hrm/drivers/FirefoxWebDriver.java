package com.orange_hrm.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static com.orange_hrm.utils.ConfigReader.getValue;


public class FirefoxWebDriver {

    public static WebDriver loadFireFoxDriver() {
//        System.setProperty("webdriver.firefox.driver", "src/main/resources/drivers/geckodriver.exe");

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size-1920,1080");
        if (Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
}

package com.orange_hrm.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

import static com.orange_hrm.utils.ConfigReader.getValue;


public class EdgeWebDriver {

    public static WebDriver loadEdgeDriver() {
//        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size-1920,1080");
        if (Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }
        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
}

package com.orange_hrm.drivers;


import com.orange_hrm.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getValue("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                case "firefox":
                    driver = FirefoxWebDriver.loadFireFoxDriver();
                    break;
                case "safari":

                    break;
                default:
                    throw new IllegalArgumentException("you provided wrong Driver name");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

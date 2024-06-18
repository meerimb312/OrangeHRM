package com.orange_hrm_test.test;

import com.orange_hrm.drivers.DriverManager;
import com.orange_hrm.helper.BrowserHelper;
import com.orange_hrm.helper.DropDownHelper;
import com.orange_hrm.helper.WebElementActions;
import com.orange_hrm.pages.HomePage;
import com.orange_hrm.pages.TopMenu;
import com.orange_hrm.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    private WebDriver driver;
    protected WebElementActions webElementActions;
    protected BrowserHelper browserHelper;
    protected RandomUtils randomUtils;
    protected DropDownHelper dropDownHelper;
    protected HomePage homePage;
    protected TopMenu topMenuPage;


    @BeforeClass(alwaysRun = true)
    public void setUp() {

        driver = DriverManager.getDriver();
        randomUtils = new RandomUtils();
        webElementActions = new WebElementActions();
        browserHelper = new BrowserHelper(driver);
        dropDownHelper = new DropDownHelper(driver);
        homePage = new HomePage(driver);
        topMenuPage = new TopMenu(driver);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }
}

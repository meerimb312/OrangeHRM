package com.orange_hrm.data;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class SideMenuData {

    public static final String LOGIN_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public static final String userName = "Admin";
    public static final String PASSWORD = "admin123";

    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com";
    public static final String HOME_PAGE_TITLE = "OrangeHRM";
    //Navbar Menu
    public static final By ADMIN_MENU = By.xpath("//span[text()='Admin']");
    public static final String ADMIN_MENU_URL = BASE_URL + "/web/index.php/admin/viewSystemUsers";
    public static final By PIM_MENU = By.xpath("//span[text()='PIM']");
    public static final String PIM_MENU_URL = BASE_URL + "/web/index.php/pim/viewEmployeeList";
    public static final By LEAVE_MENU = By.xpath("//span[text()='Leave']");
    public static final String LEAVE_MENU_URL = BASE_URL + "/web/index.php/leave/viewLeaveList";
    public static final By TIME_MENU = By.xpath("//span[text()='Time']");
    public static final String TIME_MENU_URL = BASE_URL + "/web/index.php/time/viewEmployeeTimesheet";
    public static final By RECRUITMENT_MENU = By.xpath("//span[text()='Recruitment']");
    public static final String RECRUITMENT_MENU_URL = BASE_URL + "/web/index.php/recruitment/viewCandidates";
    public static final By MY_INFO_MENU = By.xpath("//span[text()='My Info']");
    public static final String MY_INFO_MENU_URL = BASE_URL + "/web/index.php/pim/viewPersonalDetails/empNumber/7";
    public static final By PERFORMANCE_MENU = By.xpath("//span[text()='Performance']");
    public static final String PERFORMANCE_MENU_URL = BASE_URL + "/web/index.php/performance/searchEvaluatePerformanceReview";
    public static final By DASHBOARD_MENU = By.xpath("//span[text()='Dashboard']");
    public static final String DASHBOARD_MENU_URL = BASE_URL + "/web/index.php/dashboard/index";
    public static final By DIRECTORY_MENU = By.xpath("//span[text()='Directory']");
    public static final String DIRECTORY_MENU_URL = BASE_URL + "/web/index.php/directory/viewDirectory";
    public static final By MAINTENANCE_MENU = By.xpath("//span[text()='Maintenance']");
    public static final String MAINTENANCE_MENU_URL = BASE_URL + "/web/index.php/maintenance/purgeEmployee";

    public static final By CLAIM_MENU = By.xpath("//span[text()='Claim']");
    public static final String CLAIM_MENU_URL = BASE_URL + "/web/index.php/claim/viewAssignClaim";

    public static final By BUZZ_MENU = By.xpath("//span[text()='Buzz']");
    public static final String BUZZ_MENU_URL = BASE_URL + "/web/index.php/buzz/viewBuzz";

    @Step("Navigation all side panel menu")
    @DataProvider(name = "sideMenuData")
    public static Object[][] getSideMenuData() {
        return new Object[][]{
                {BASE_URL, ADMIN_MENU, ADMIN_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, PIM_MENU, PIM_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, LEAVE_MENU, LEAVE_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, TIME_MENU, TIME_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, RECRUITMENT_MENU, RECRUITMENT_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, MY_INFO_MENU, MY_INFO_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, PERFORMANCE_MENU, PERFORMANCE_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, DASHBOARD_MENU, DASHBOARD_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, DIRECTORY_MENU, DIRECTORY_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, MAINTENANCE_MENU, MAINTENANCE_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, CLAIM_MENU, CLAIM_MENU_URL, HOME_PAGE_TITLE},
                {BASE_URL, BUZZ_MENU, BUZZ_MENU_URL, HOME_PAGE_TITLE},
        };
    }
}
package scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private static final Logger logger = LogManager.getLogger(DashboardTest.class);

    @BeforeMethod
    public void setupDashboardPage() {
        driver.get("https://olms.codedao.io.vn/login");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        // Đăng nhập thành công trước khi test các chức năng của Dashboard
        loginPage.login("testadmin", "test1234");
        Assert.assertTrue(dashboardPage.isDashboardTitleDisplayed(), "Đăng nhập không thành công hoặc không chuyển đến Dashboard.");
        logger.info("Đã đăng nhập thành công và điều hướng đến Dashboard.");
    }

    @Test
    public void testNavigateToAddNewEmployeePage() {
        dashboardPage.clickAddNewEmployeeButton();
        logger.info("Đã click nút Thêm mới nhân viên.");
    }

    @Test
    public void testNavigateToEmployeeManagementPage() {
        dashboardPage.clickEmployeeManagementLink();
        logger.info("Đã click link Quản lý nhân viên.");
    }

    @Test
    public void testLogoutFromDashboard() {
        dashboardPage.clickLogoutButton();
        logger.info("Đã click nút Đăng xuất.");
    }
}

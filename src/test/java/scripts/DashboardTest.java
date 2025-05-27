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
        // Ở đây bạn cần thêm Assert để kiểm tra xem bạn đã chuyển đến trang Thêm mới nhân viên hay chưa
        // Ví dụ: Assert.assertTrue(driver.getCurrentUrl().contains("/employee/add"), "Không chuyển đến trang Thêm mới nhân viên.");
        logger.info("Đã click nút Thêm mới nhân viên.");
    }

    @Test
    public void testNavigateToEmployeeManagementPage() {
        dashboardPage.clickEmployeeManagementLink();
        // Ở đây bạn cần thêm Assert để kiểm tra xem bạn đã chuyển đến trang Quản lý nhân viên hay chưa
        // Ví dụ: Assert.assertTrue(driver.getCurrentUrl().contains("/employee/manage"), "Không chuyển đến trang Quản lý nhân viên.");
        logger.info("Đã click link Quản lý nhân viên.");
    }

    @Test
    public void testLogoutFromDashboard() {
        dashboardPage.clickLogoutButton();
        // Ở đây bạn cần thêm Assert để kiểm tra xem bạn đã quay lại trang đăng nhập hay chưa
        // Ví dụ: Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Không đăng xuất thành công.");
        logger.info("Đã click nút Đăng xuất.");
    }
}

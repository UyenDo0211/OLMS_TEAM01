package scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EmployeeManagementPage;
import pages.LoginPage;

public class EmployeeManagementTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private EmployeeManagementPage employeeManagementPage;
    private static final Logger logger = LogManager.getLogger(EmployeeManagementTest.class);

    @BeforeMethod
    public void setupEmployeeManagementPage() {
        driver.get("https://olms.codedao.io.vn/login");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        employeeManagementPage = new EmployeeManagementPage(driver);

        // Đăng nhập thành công và điều hướng đến trang Quản lý nhân viên
        loginPage.login("testadmin", "test1234");
        Assert.assertTrue(dashboardPage.isDashboardTitleDisplayed(), "Đăng nhập không thành công hoặc không chuyển đến Dashboard.");
        dashboardPage.clickEmployeeManagementLink();
        logger.info("Đã điều hướng đến trang Quản lý nhân viên.");
    }

    @Test
    public void testEmployeeTableIsDisplayed() {
        Assert.assertTrue(employeeManagementPage.isEmployeeTableDisplayed(), "Bảng nhân viên không hiển thị.");
        logger.info("Kiểm tra bảng nhân viên hiển thị.");
    }

    @Test
    public void testSearchEmployee() {
        String searchTerm = "John"; // Ví dụ: Tìm kiếm theo tên
        employeeManagementPage.enterSearchTerm(searchTerm);

        logger.info("Đã thực hiện tìm kiếm nhân viên với từ khóa: " + searchTerm);
    }

    @Test
    public void testDeleteFirstEmployee() {
        String firstEmployeeName = employeeManagementPage.getFirstEmployeeName();
        employeeManagementPage.clickDeleteFirstEmployeeButton();

        logger.info("Đã click nút Xóa nhân viên đầu tiên.");
    }
}

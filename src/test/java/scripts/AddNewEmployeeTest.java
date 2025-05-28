package scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddNewEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;

public class AddNewEmployeeTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AddNewEmployeePage addNewEmployeePage;
    private static final Logger logger = LogManager.getLogger(AddNewEmployeeTest.class);

    @BeforeMethod
    public void setupAddNewEmployeePage() {
        driver.get("https://olms.codedao.io.vn/login");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        addNewEmployeePage = new AddNewEmployeePage(driver);

        // Đăng nhập thành công và điều hướng đến trang Thêm mới nhân viên
        loginPage.login("testadmin", "test1234");
        Assert.assertTrue(dashboardPage.isDashboardTitleDisplayed(), "Đăng nhập không thành công hoặc không chuyển đến Dashboard.");
        dashboardPage.clickAddNewEmployeeButton();
        logger.info("Đã điều hướng đến trang Thêm mới nhân viên.");
    }

    @Test
    public void testAddNewEmployeeSuccessfullyWithAllFields() {
        String fullName = "Nguyen Van A";
        String firstName = "A";
        String birthday = "01/01/1990";
        String department = "Văn phòng"; // Chọn một phòng ban hợp lệ
        String startDate = "01/06/2025";
        String contractLink = "https://example.com/contract123";
        String username = "nva123";
        String password = "password123";
        String sdt = "0901234567";

        addNewEmployeePage.addNewEmployee(fullName, firstName, birthday, department, startDate, contractLink, username, password, sdt);
        Assert.assertTrue(addNewEmployeePage.isSuccessMessageDisplayed(), "Không thấy thông báo thêm nhân viên thành công.");
        logger.info("Đã thêm nhân viên thành công với đầy đủ thông tin.");

    }

    @Test
    public void testAddNewEmployeeWithOfficeDepartment() {
        addNewEmployeePage.selectOfficeRadioButton();
        // Thêm các bước nhập liệu và kiểm tra khác nếu cần
        logger.info("Đã chọn phòng ban Văn phòng.");
    }

    @Test
    public void testAddNewEmployeeWithTrainingDepartment() {
        addNewEmployeePage.selectTrainingRadioButton();
        // Thêm các bước nhập liệu và kiểm tra khác nếu cần
        logger.info("Đã chọn phòng ban Đào tạo.");
    }

    @Test
    public void testCancelAddNewEmployee() {
        addNewEmployeePage.enterFullName("Tran Thi B");
        addNewEmployeePage.clickCancelButton();
        // Ở đây bạn cần thêm Assert để kiểm tra xem bạn đã quay lại trang Dashboard hoặc trang trước đó hay chưa
        // Ví dụ: Assert.assertTrue(dashboardPage.isDashboardTitleDisplayed(), "Không quay lại trang Dashboard sau khi hủy.");
        logger.info("Đã click nút HỦY BỎ.");
    }
}

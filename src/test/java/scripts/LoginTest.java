package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.testng.Assert.*; // Import static các phương thức của Assert

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @BeforeMethod
    public void openLoginPage() {
        driver.get("https://olms.codedao.io.vn/login");
        loginPage = new LoginPage(driver);
        logger.info("Mở trang đăng nhập: https://olms.codedao.io.vn/login");
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login("testadmin", "test1234");
        assertTrue(loginPage.isLoginSuccessful(), "Đăng nhập không thành công."); // Đã sửa dòng này
        logger.info("Kiểm tra đăng nhập thành công.");
    }
}

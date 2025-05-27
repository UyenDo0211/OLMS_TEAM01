package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class LoginPage {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        logger.info("Khởi tạo trang LoginPage.");
    }

    public void enterUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameInput);
        usernameElement.sendKeys(username);
        logger.info("Nhập tên đăng nhập: " + username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.sendKeys(password);
        logger.info("Nhập mật khẩu: " + password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
        logger.info("Click nút Đăng nhập.");
    }

    public boolean isLoginSuccessful() {
        // Điều kiện để xác định đăng nhập thành công.
        // Bạn cần xác định một element duy nhất xuất hiện sau khi đăng nhập thành công.
        // Ví dụ: có thể là một button "Đăng xuất" hoặc một dashboard title.
        try {
            return driver.findElement(By.xpath("//*[contains(text(), 'Trang chủ')]")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.warn("Không tìm thấy element xác nhận đăng nhập thành công.");
            return false;
        }
    }

    public String getErrorMessage() {
        // Tìm kiếm element hiển thị thông báo lỗi đăng nhập (nếu có).
        try {
            WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
            String errorMessage = errorMessageElement.getText();
            logger.warn("Lấy thông báo lỗi: " + errorMessage);
            return errorMessage;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.info("Không tìm thấy thông báo lỗi.");
            return null;
        }
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

}

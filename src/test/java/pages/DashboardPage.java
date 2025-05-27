package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DashboardPage.class);

    // Locators cho các elements trên trang Dashboard
    private By dashboardTitle = By.xpath("//h1[contains(text(), 'Bảng điều khiển')]");
    private By addNewEmployeeButton = By.xpath("//button[contains(text(), 'Thêm nhân viên')]");
    private By employeeManagementLink = By.xpath("//a[contains(text(), 'Quản lý nhân viên')]");
    private By logoutButton = By.xpath("//button[contains(text(), 'Đăng xuất')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        logger.info("Khởi tạo trang DashboardPage.");
    }

    public boolean isDashboardTitleDisplayed() {
        try {
            WebElement titleElement = driver.findElement(dashboardTitle);
            boolean isDisplayed = titleElement.isDisplayed();
            logger.info("Kiểm tra hiển thị tiêu đề Dashboard: " + isDisplayed);
            return isDisplayed;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.warn("Không tìm thấy tiêu đề Dashboard.");
            return false;
        }
    }

    public void clickAddNewEmployeeButton() {
        try {
            WebElement addButton = driver.findElement(addNewEmployeeButton);
            addButton.click();
            logger.info("Click nút Thêm mới nhân viên.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.error("Không tìm thấy nút Thêm mới nhân viên.");
        }
    }

    public void clickEmployeeManagementLink() {
        try {
            WebElement manageLink = driver.findElement(employeeManagementLink);
            manageLink.click();
            logger.info("Click link Quản lý nhân viên.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.error("Không tìm thấy link Quản lý nhân viên.");
        }
    }

    public void clickLogoutButton() {
        try {
            WebElement logoutBtn = driver.findElement(logoutButton);
            logoutBtn.click();
            logger.info("Click nút Đăng xuất.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.error("Không tìm thấy nút Đăng xuất.");
        }
    }
}

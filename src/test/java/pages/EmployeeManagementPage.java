package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeManagementPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(EmployeeManagementPage.class);

    // Locators cho các elements trên trang Quản lý nhân viên
    private By employeeTable = By.id("employeeTable");
    private By searchInput = By.id("employeeSearch");
    private By firstEmployeeName = By.xpath("//table[@id='employeeTable']/tbody/tr[1]/td[1]");
    private By deleteButtonFirstEmployee = By.xpath("//table[@id='employeeTable']/tbody/tr[1]/td[last()]/button[contains(text(), 'Xóa')]");

    public EmployeeManagementPage(WebDriver driver) {
        this.driver = driver;
        logger.info("Khởi tạo trang EmployeeManagementPage.");
    }

    public boolean isEmployeeTableDisplayed() {
        try {
            WebElement tableElement = driver.findElement(employeeTable);
            boolean isDisplayed = tableElement.isDisplayed();
            logger.info("Kiểm tra hiển thị bảng nhân viên: " + isDisplayed);
            return isDisplayed;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.warn("Không tìm thấy bảng nhân viên.");
            return false;
        }
    }

    public void enterSearchTerm(String searchTerm) {
        try {
            WebElement searchInputElement = driver.findElement(searchInput);
            searchInputElement.sendKeys(searchTerm);
            logger.info("Nhập từ khóa tìm kiếm: " + searchTerm);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.error("Không tìm thấy input tìm kiếm nhân viên.");
        }
    }

    public String getFirstEmployeeName() {
        try {
            WebElement nameElement = driver.findElement(firstEmployeeName);
            String name = nameElement.getText();
            logger.info("Lấy tên nhân viên đầu tiên: " + name);
            return name;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.warn("Không tìm thấy tên nhân viên đầu tiên.");
            return null;
        }
    }

    public void clickDeleteFirstEmployeeButton() {
        try {
            WebElement deleteBtn = driver.findElement(deleteButtonFirstEmployee);
            deleteBtn.click();
            logger.info("Click nút Xóa của nhân viên đầu tiên.");
            // Có thể cần thêm xử lý cho confirm dialog nếu có
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.error("Không tìm thấy nút Xóa của nhân viên đầu tiên.");
        }
    }
}

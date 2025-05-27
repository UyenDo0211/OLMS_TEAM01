package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>(); //để chạy song song các test cùng chạy với drive

//    static WebDriver driver;

    public static void setDriver(String browser){

        WebDriver driver = null; // đi cùng với ThreadLocal (ở trên)

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("This browser is not support");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        threadLocalDriver.set(driver);
    }

    public static WebDriver getDriver() {

        return threadLocalDriver.get();
//        return driver;
    }
}

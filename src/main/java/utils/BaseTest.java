package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    public void setUp(String target) {
        System.setProperty("webdriver.chrome.driver", "src/drive/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(target);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

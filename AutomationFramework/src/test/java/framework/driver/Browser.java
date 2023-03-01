package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static WebDriver driver;

    private Browser() {
    }

    public static WebDriver setupDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //  options.addArguments("--headless");
            options.addArguments("--window-size=1920,1200");
            options.addArguments("--lang=en");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        driver.close();
    }
}

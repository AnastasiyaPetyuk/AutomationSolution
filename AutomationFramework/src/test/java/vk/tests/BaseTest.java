package vk.tests;

import framework.driver.Browser;
import framework.utils.GetProperties;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.logging.Logger;

public class BaseTest {

    public static final Logger logger = Logger.getLogger(steam.tests.BaseTest.class.getName());

    protected static WebDriver driver;

    @BeforeSuite
    public void setUpDriver() {
        logger.info("set up driver");
        driver = Browser.setupDriver();
        driver.get(GetProperties.getProperties("config", "mainUrlVk"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void attachScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            String screenshotName = result.getName() + System.currentTimeMillis() + ".png";
            try {
                // Take the screenshot and save it to a file
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshotFile, new File("src/test/screenshots/" + screenshotName));

                // Attach the screenshot to the Allure report
                attachScreenshotToAllure(screenshotFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] attachScreenshotToAllure(File screenshot) {
        try {
            return Files.readAllBytes(screenshot.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @AfterSuite
    public void closeDriver() {
        logger.info("close driver");
        Browser.closeDriver();
    }
}

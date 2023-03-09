package framework.pageElements;

import framework.driver.Browser;
import framework.utils.MyWaiters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseElement {
    private WebElement webElement;
    protected By locator;
    protected String partOfLocator;

    public BaseElement(By locator) {
        this.locator = locator;
    }
    public BaseElement(String partOfLocator) {
        this.partOfLocator = partOfLocator;
    }
    public void click() {
        webElement = MyWaiters.waitForElementToBeVisible(locator);
        webElement.click();
    }
    public String getText() {
        webElement = MyWaiters.waitForElementToBeVisible(locator);
        return webElement.getText();
    }
    public void sendText(String str) {
        webElement = MyWaiters.waitForElementToBeVisible(locator);
        webElement.sendKeys(str);
    }
    public boolean isDisplayed() {
        MyWaiters.waitForElementToBeVisible(locator);
        return webElement.isDisplayed();
    }
    public void moveCursorToElement() {
        webElement = MyWaiters.waitForElementToBeVisible(locator);
        new Actions(Browser.getDriver()).moveToElement(webElement).build().perform();
    }
    public void scrollDownToElement() {
        webElement = MyWaiters.waitForElementToBeVisible(locator);
        new Actions(Browser.getDriver()).scrollToElement(webElement).build().perform();
    }

}

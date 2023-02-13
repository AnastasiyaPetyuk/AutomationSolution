package framework.pageElements;

import framework.driver.Browser;
import framework.utils.MyWaiters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseElement {
    private WebElement webElement;
    protected By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public void click() {
        webElement = MyWaiters.waitForElementToBeVisible(locator);
        webElement.click();
    }
    public String getText() {
        webElement = MyWaiters.waitForElementToBeVisible(locator);
        return webElement.getText();
    }

    public List<String> getAllText(String locator, String s) {
        List<WebElement> list = Browser.getDriver().findElements(By.xpath(String.format(locator, s)));
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public List<String> convertListOfWebElementsToListOfStrings() {
        List<WebElement> listOfWebElements = Browser.getDriver().findElements(locator);
        List<String> stringListOfSales = new ArrayList<>();
        for (WebElement element : listOfWebElements) {
            stringListOfSales.add(element.getText());
        }
        return stringListOfSales;
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

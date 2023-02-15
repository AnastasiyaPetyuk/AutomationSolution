package framework.pageElements;

import framework.driver.Browser;
import framework.utils.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfElements<T> extends BaseElement{
    private List<WebElement> listOfElements;
    protected String s;
    public ListOfElements(By locator) {
        super(locator);
    }
    public ListOfElements(String partOfLocator) {
        super(partOfLocator);
    }

    public List<String> getListOfText() { //
        List<WebElement> listOfWebElements = Browser.getDriver().findElements(locator);
        List<String> stringList = new ArrayList<>();
        for (WebElement element : listOfWebElements) {
            stringList.add(element.getText());
        }
        return stringList;
    }
    public List<String> getAllText() {
        listOfElements = MyWaiters.waitForElementsToBeVisible(locator);
        List<WebElement> list = listOfElements;
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public List<String> getAllText(String s) {
        this.locator = By.xpath(String.format(partOfLocator, s));
        listOfElements = MyWaiters.waitForElementsToBeVisible(locator);
        List<WebElement> list = listOfElements;
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}

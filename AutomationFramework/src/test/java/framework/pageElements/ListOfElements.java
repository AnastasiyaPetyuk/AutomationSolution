package framework.pageElements;

import framework.driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListOfElements<T> extends BaseElement{
    public ListOfElements(By locator) {
        super(locator);
    }
    public List<String> getListOfTexts() {
        List<WebElement> listOfWebElements = Browser.getDriver().findElements(locator);
        List<String> stringListOfSales = new ArrayList<>();
        for (WebElement element : listOfWebElements) {
            stringListOfSales.add(element.getText());
        }
        return stringListOfSales;
    }
}

package steam.pages;

import framework.page.BasePage;
import framework.pageElements.Label;
import framework.pageElements.ListOfElements;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.List;

public class SpecialOffersPage extends BasePage {
    protected static final Label specialOffersPageUniqueLabel = new Label(By.xpath("//div[contains(text(), 'Special Offers')]"));
    private static Label allItemsCategory = new Label(By.xpath("//div[contains(@class, 'sale_item')]"));
    private final ListOfElements<WebElement> listOfGameSale = new ListOfElements<>(By.xpath("//div[contains(@class,'salepreviewwidgets_StoreSaleWidgetRight')]//div[contains(@class, \"StoreSaleDiscountBox\")]"));
    private final ListOfElements<WebElement> listOfStartedPrice = new ListOfElements<>(By.xpath("//div[contains(@class,'salepreviewwidgets_StoreSaleWidgetRight')]//div[contains(@class, \"StoreOriginalPrice\")]"));
    private final ListOfElements<WebElement> listOfCurrentPrice = new ListOfElements<>(By.xpath("//div[contains(@class,'salepreviewwidgets_StoreSaleWidgetRight')]//div[contains(@class, \"StoreSalePriceBox\")]"));

    public SpecialOffersPage() {
        uniqueElement = specialOffersPageUniqueLabel;
    }
    @Step("scroll down to List Of Offers")
    public void scrollDownToListOfOffers() {
        allItemsCategory.scrollDownToElement();
    }
    public List<String> getTextFromListOfGameSale() {
        return listOfGameSale.getAllText();
    }
    public List<String> getTextFromListOfStartedPrice() {
        return listOfStartedPrice.getAllText();
    }
    public List<String> getTextFromListOfCurrentPrice() {
        return listOfCurrentPrice.getAllText();
    }
}

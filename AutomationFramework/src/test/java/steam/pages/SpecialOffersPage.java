package steam.pages;

import framework.page.BasePage;
import framework.pageElements.Label;
import org.openqa.selenium.*;

public class SpecialOffersPage extends BasePage {
    protected static final Label specialOffersPageUniqueLabel = new Label(By.xpath("//div[contains(text(), 'Special Offers')]"));
    private static Label allItemsCategory = new Label(By.xpath("//div[contains(@class, 'sale_item')]"));

    public SpecialOffersPage() {
        uniqueElement = specialOffersPageUniqueLabel;
    }
    public void scrollDownToTheListOfOffers() {
        allItemsCategory.scrollDownToElement();
    }
}

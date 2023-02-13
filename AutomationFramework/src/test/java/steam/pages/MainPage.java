package steam.pages;

import framework.driver.Browser;
import framework.page.BasePage;
import framework.pageElements.Button;
import framework.pageElements.Label;
import framework.pageElements.ListOfElements;
import framework.utils.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class MainPage extends BasePage {
    protected final Label mainPageUniqueLabel = new Label(By.xpath("//div[contains(@class, 'capsule main_capsule')]"));
    private final Button categoriesButton = new Button(By.xpath("//a[contains(text(), 'Categories')]"));
    private final Button newAndNoteworthyButton = new Button(By.xpath("//a[contains(text(), 'New & Noteworthy')]"));
    private final Button specialOffersButton = new Button(By.xpath("//a[contains(text(), 'Special Offers')]"));
    private final Label newAndTrendingLabel = new Label(By.xpath("//div[@class=\"home_ctn tab_container\"]"));
    private final Button goToMainPageButton = new Button(By.xpath("//span[@id=\"logo_holder\"]"));
    protected final Label partOfLocatorLabel = new Label(By.xpath("//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a"));
    protected final Label firstGameInList = new Label(By.xpath("//div[@class=\"tab_item_content\"]"));
    private final Label tabPreviewOfFirstElement = new Label(By.xpath("//div[@class=\"home_rightcol\"]"));
    private final Label nameOfFirstElement = new Label(By.xpath("//div[@class=\"tab_preview focus\"]/h2"));
    private final ListOfElements listOfTagsOfFirstElement = new ListOfElements(By.xpath("//div[@class='tags']/a"));
    private final Label reviewsStatusOfFirstElement = new Label(By.xpath("//span[contains(@class,'game_review_summary positive')]"));
    private final Label priceOfFirstElement = new Label(By.xpath("//div[contains(@class,\"tab_item\")]//div[@class='discount_final_price']"));
    private final String partOfLocator = "//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a";
    private final By arcadeAndRhythmLocator = By.xpath("//div[@data-genre-group='action'][2]/following-sibling::div[1]/a");


    public MainPage() {
        uniqueElement = mainPageUniqueLabel;
    }

    public void waitingOfDisplayedListsOfCategories() {
        WebElement element = Browser.getDriver().findElement(arcadeAndRhythmLocator);
        MyWaiters.waitForTextToBePresentInElement(element, "Arcade & Rhythm");
    }
    public void hoverOnCategories() {
        categoriesButton.moveCursorToElement();
    }
    public void hoverOnNewAndNoteworthy() {
        newAndNoteworthyButton.moveCursorToElement();
        Browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }
    public void clickToSpecialOffers() {
        specialOffersButton.click();
    }
    public void scrollDownToLabelNewAndTrending() {
        newAndTrendingLabel.scrollDownToElement();
    }
    public void goToMainPage() {
        goToMainPageButton.click();
    }
    public List<String> getTextFromAllSubCategories(String s) {
        return partOfLocatorLabel.getAllText(partOfLocator, s);
    }
    public void hoverOnFirstGameInList() {
        firstGameInList.moveCursorToElement();
    }
    public void hoverOnTabPreviewOfFirstElement() {
        tabPreviewOfFirstElement.moveCursorToElement();
    }
    public String getTextFromNameOfFirstElement() {
        return nameOfFirstElement.getText();
    }
    public String getTextFromReviewsStatusOfFirstElement() {
        return reviewsStatusOfFirstElement.getText();
    }
    public void clickOnFirstGameInList() {
        firstGameInList.click();
    }
    public String getTextFromPriceOfFirstElement() {
        return priceOfFirstElement.getText().toString().replaceAll("[aA-zZ, \s]", "");
    }
    public List<String> getTextFromListOfTagsOfFirstElement() {
        return listOfTagsOfFirstElement.getListOfTexts().subList(0, 3);
    }
    public List<String> getListOfCategories() {
        List<String> listOfCategories = new ArrayList<>();
        listOfCategories.add("action");
        listOfCategories.add("rpg");
        listOfCategories.add("strategy");
        return listOfCategories;
    }

}

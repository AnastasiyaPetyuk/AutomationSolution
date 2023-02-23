package steam.pages;

import framework.constants.Regex;
import framework.driver.Browser;
import framework.page.BasePage;
import framework.pageElements.Button;
import framework.pageElements.Label;
import framework.pageElements.ListOfElements;
import framework.utils.MyWaiters;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MainPage extends BasePage {
    protected final Label mainPageUniqueLabel = new Label(By.xpath("//div[contains(@class, 'capsule main_capsule')]"));
    private final Button categoriesButton = new Button(By.xpath("//a[contains(text(), 'Categories')]"));
    private final Button newAndNoteworthyButton = new Button(By.xpath("//a[contains(text(), 'New & Noteworthy')]"));
    private final Button specialOffersButton = new Button(By.xpath("//a[contains(text(), 'Special Offers')]"));
    private final Label newAndTrendingLabel = new Label(By.xpath("//div[@class=\"home_ctn tab_container\"]"));
    private final Button goToMainPageButton = new Button(By.xpath("//span[@id=\"logo_holder\"]"));
    protected final Label firstGameInList = new Label(By.xpath("//div[@class=\"tab_item_content\"]"));
    private final Label tabPreviewOfFirstElement = new Label(By.xpath("//div[@class=\"home_rightcol\"]"));
    private final Label nameOfFirstElement = new Label(By.xpath("//div[@class=\"tab_preview focus\"]/h2"));
    private final ListOfElements listOfTagsOfFirstElement = new ListOfElements(By.xpath("//div[@class='tags']/a"));
    private final Label reviewsStatusOfFirstElement = new Label(By.xpath("//span[contains(@class,'game_review_summary')]"));
    private final Label priceOfFirstElement = new Label(By.xpath("//div[contains(@class,\"tab_item\")]//div[@class='discount_final_price']"));
    private final By arcadeAndRhythmLocator = By.xpath("//div[@data-genre-group='action'][2]/following-sibling::div[1]/a");

    private final ListOfElements partOfLocator = new ListOfElements("//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a");


    public MainPage() {
        uniqueElement = mainPageUniqueLabel;
    }

    public void waitingOfDisplayedListsOfCategories() {
        WebElement element = Browser.getDriver().findElement(arcadeAndRhythmLocator);
        MyWaiters.waitForTextToBePresentInElement(element, "Arcade & Rhythm");
    }
    @Step("hover on 'Categories'")
    public void hoverOnCategories() {
        categoriesButton.moveCursorToElement();
    }
    @Step("hover on 'New & Noteworthy'")
    public void hoverOnNewAndNoteworthy() {
        newAndNoteworthyButton.moveCursorToElement();
    }
    @Step("click to 'Special Offers'")
    public void clickToSpecialOffers() {
        specialOffersButton.click();
    }
    @Step("scroll down to label 'New & Trending'")
    public void scrollDownToLabelNewAndTrending() {
        newAndTrendingLabel.scrollDownToElement();
    }
    public void goToMainPage() {
        goToMainPageButton.click();
    }
    public List<String> getTextFromSubCategories(String s) {
        return partOfLocator.getAllText(s);
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
        return priceOfFirstElement.getText().toString().replaceAll(Regex.onlyLettersRegex, "");
    }
    public List<String> getTextFromListOfTagsOfFirstElement() {
        return listOfTagsOfFirstElement.getListOfText();

    }
}

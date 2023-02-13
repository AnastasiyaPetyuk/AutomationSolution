package steam.steps;

import framework.driver.Browser;
import framework.pageElements.Label;
import framework.pageElements.ListOfElements;
import framework.utils.GetProperties;
import framework.utils.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainPageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());
    protected final Label partOfLocatorLabel = new Label(By.xpath("//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a"));
    protected final Label firstGameInList = new Label(By.xpath("//div[@class=\"tab_item_content\"]"));
    private final Label tabPreviewOfFirstElement = new Label(By.xpath("//div[@class=\"home_rightcol\"]"));
    private final Label nameOfFirstElement = new Label(By.xpath("//div[@class=\"tab_preview focus\"]/h2"));
    private final ListOfElements listOfTagsOfFirstElement = new ListOfElements(By.xpath("//div[@class='tags']/a"));
    private final Label reviewsStatusOfFirstElement = new Label(By.xpath("//span[contains(@class,'game_review_summary positive')]"));
    private final Label priceOfFirstElement = new Label(By.xpath("//div[contains(@class,\"tab_item\")]//div[@class='discount_final_price']"));

    public void waitingOfDisplayedListsOfCategories() {
        WebElement element = Browser.getDriver().findElement(By.xpath("//div[@data-genre-group='action'][2]/following-sibling::div[1]/a"));
        MyWaiters.waitForTextToBePresentInElement(element, "Arcade & Rhythm");
    }

    public boolean equalsListOfCategories(String s) {     // s = "action", "rpg", "strategy"
        logger.info("check equals of categories in field " + s);
        String partOfLocator = "//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a";
        List<String> actualString = new ArrayList<>(partOfLocatorLabel.getAllText(partOfLocator, s));
        List<String> expectedString = new ArrayList<>();
        String line = GetProperties.getProperties("categories", s);
        expectedString = Stream.of(line.split(",")).collect(Collectors.toList());
        return actualString.equals(expectedString);
    }

    public ArrayList<String> getGameInfoFromMainPage() {
        logger.info("Observe info of the game from the list");
        ArrayList<String> listOfInformation = new ArrayList<>();
        firstGameInList.moveCursorToElement();
        tabPreviewOfFirstElement.moveCursorToElement();

        listOfInformation.add(nameOfFirstElement.getText());
        listOfInformation.add(reviewsStatusOfFirstElement.getText());
        listOfInformation.add(priceOfFirstElement.getText().toString().replaceAll("[aA-zZ, \s]", ""));

        logger.info("Click on game and to the game’s page");
        firstGameInList.click();
        return listOfInformation;
    }
    public ArrayList<String> getTagsFromMainPage() {
        ArrayList<String> listOfTags = new ArrayList<>(listOfTagsOfFirstElement.convertListOfWebElementsToListOfStrings().subList(0, 3));
        logger.info("tags from main page " + listOfTags);
        firstGameInList.click();
        return listOfTags;
    }







}

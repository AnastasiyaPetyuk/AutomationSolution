package steam.steps;

import framework.pageElements.Label;
import framework.pageElements.ListOfElements;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.logging.Logger;

public class GamePageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());
    private final Label nameOfGame = new Label(By.xpath("//div[@class=\"apphub_AppName\"]"));
    private final ListOfElements listOfTagsOfGame = new ListOfElements(By.xpath("//div[@class=\"glance_tags popular_tags\"]/a"));
    private final Label reviewsStatusOfGame = new Label(By.xpath("//span[contains(@class,'game_review_summary positive')]"));
    private final Label priceOfGame = new Label(By.xpath("//div[@class='discount_final_price']"));

    public ArrayList getGameInfoFromGamePage() {
        logger.info("Observe game’s info on opened page");
        ArrayList<String> listOfInformation = new ArrayList<>();
        listOfInformation.add(nameOfGame.getText());
        listOfInformation.add(reviewsStatusOfGame.getText());
        listOfInformation.add(priceOfGame.getText().toString().replaceAll("[aA-zZ, \s]", ""));
        return listOfInformation;
    }
    public ArrayList<String> getTagsFromGamePage() {
        ArrayList<String> listOfTags = new ArrayList<>(listOfTagsOfGame.convertListOfWebElementsToListOfStrings().subList(0, 3));
        logger.info("tags from game page " + listOfTags);
        return listOfTags;
    }


}

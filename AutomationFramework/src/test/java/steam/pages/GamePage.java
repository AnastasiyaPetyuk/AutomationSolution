package steam.pages;

import framework.pageElements.Label;
import framework.pageElements.ListOfElements;
import org.openqa.selenium.By;

import java.util.List;

public class GamePage {
    private final Label nameOfGame = new Label(By.xpath("//div[@class=\"apphub_AppName\"]"));
    private final ListOfElements listOfTagsOfGame = new ListOfElements(By.xpath("//div[@class=\"glance_tags popular_tags\"]/a"));
    private final Label reviewsStatusOfGame = new Label(By.xpath("//span[contains(@class,'game_review_summary positive')]"));
    private final Label priceOfGame = new Label(By.xpath("//div[@class='discount_final_price']"));
    public String getTextFromNameOfGame() {
        return nameOfGame.getText();
    }
    public String getTextFromReviewsStatusOfGame() {
        return  reviewsStatusOfGame.getText();
    }
    public String getTextFromPriceOfGame() {
        return priceOfGame.getText().toString().replaceAll("[aA-zZ, \s]", "");
    }
    public List<String> getTextFromListOfTagsOfGame() {
        return listOfTagsOfGame.getListOfTexts().subList(0, 3);
    }
}

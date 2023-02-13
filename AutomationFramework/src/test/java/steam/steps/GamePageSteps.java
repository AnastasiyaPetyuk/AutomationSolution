package steam.steps;

import steam.pages.GamePage;

import java.util.ArrayList;
import java.util.logging.Logger;

public class GamePageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());

    public ArrayList<String> getGameInfoFromGamePage() {
        GamePage gamePage = new GamePage();
        logger.info("Observe game’s info on opened page");
        ArrayList<String> listOfInformation = new ArrayList<>();
        listOfInformation.add(gamePage.getTextFromNameOfGame());
        listOfInformation.add(gamePage.getTextFromReviewsStatusOfGame());
        listOfInformation.add(gamePage.getTextFromPriceOfGame());
        return listOfInformation;
    }
    public ArrayList<String> getTagsFromGamePage() {
        GamePage gamePage = new GamePage();
        ArrayList<String> listOfTags = new ArrayList<>(gamePage.getTextFromListOfTagsOfGame());
        logger.info("tags from game page " + listOfTags);
        return listOfTags;
    }


}

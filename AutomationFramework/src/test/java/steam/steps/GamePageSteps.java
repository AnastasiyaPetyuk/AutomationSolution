package steam.steps;

import steam.entity.GameEntity;
import steam.pages.GamePage;

import java.util.ArrayList;
import java.util.logging.Logger;

public class GamePageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());

    public GameEntity getGameInfoFromGamePage() {
        GamePage gamePage = new GamePage();
        logger.info("Observe game’s info on opened page");
        ArrayList<String> listOfTags = new ArrayList<>(gamePage.getTextFromListOfTagsOfGame());
        GameEntity gameEntity = new GameEntity(gamePage.getTextFromNameOfGame(), gamePage.getTextFromReviewsStatusOfGame(), gamePage.getTextFromPriceOfGame(), listOfTags);

        return gameEntity;
    }

}

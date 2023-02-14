package steam.steps;

import framework.utils.GetProperties;
import steam.entity.GameEntity;
import steam.pages.MainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainPageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());

    public boolean equalsListOfCategories(List<String> listOfCategories) {
        logger.info("check equals of categories in field ");
        MainPage mainPage = new MainPage();
        mainPage.waitingOfDisplayedListsOfCategories();
            for (int i = 0; i < listOfCategories.size(); i++) {
                List<String> expectedString = listOfCategories;
                String s = expectedString.get(i);
                List<String> actualString = new ArrayList<>(mainPage.getTextFromSubCategories(s));
                String line = GetProperties.getProperties("categories", s);
                expectedString = Stream.of(line.split(",")).collect(Collectors.toList());
                if (!actualString.equals(expectedString)) {
                    return false;
                }
            }
        return true;
    }

    public GameEntity getGameInfoFromMainPage() {
        logger.info("Observe info of the game from the list");
        MainPage mainPage = new MainPage();
        ArrayList<String> listOfTags = new ArrayList<>(mainPage.getTextFromListOfTagsOfFirstElement());
        mainPage.hoverOnFirstGameInList();
        mainPage.hoverOnTabPreviewOfFirstElement();
        GameEntity gameEntity = new GameEntity(mainPage.getTextFromNameOfFirstElement(), mainPage.getTextFromReviewsStatusOfFirstElement(), mainPage.getTextFromPriceOfFirstElement(), listOfTags);
        logger.info("Click on game and to the game’s page");
        mainPage.clickOnFirstGameInList();
        return gameEntity;
    }
}

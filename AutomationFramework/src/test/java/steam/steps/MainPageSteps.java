package steam.steps;

import framework.utils.GetProperties;
import steam.pages.MainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainPageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());

    public boolean equalsListOfCategories() {
        logger.info("check equals of categories in field ");
        MainPage mainPage = new MainPage();
        mainPage.waitingOfDisplayedListsOfCategories();

        for(int i = 0; i < mainPage.getListOfCategories().size(); i++) {
            List<String> expectedString = mainPage.getListOfCategories();
            List<String> actualString = new ArrayList<>(mainPage.getTextFromAllSubCategories(expectedString.get(i)));
            String line = GetProperties.getProperties("categories", expectedString.get(i).toString());
            expectedString = Stream.of(line.split(",")).collect(Collectors.toList());
            if(!actualString.equals(expectedString)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> getGameInfoFromMainPage() {
        logger.info("Observe info of the game from the list");
        MainPage mainPage = new MainPage();
        ArrayList<String> listOfInformation = new ArrayList<>();
        mainPage.hoverOnFirstGameInList();
        mainPage.hoverOnTabPreviewOfFirstElement();
        listOfInformation.add(mainPage.getTextFromNameOfFirstElement());
        listOfInformation.add(mainPage.getTextFromReviewsStatusOfFirstElement());
        listOfInformation.add(mainPage.getTextFromPriceOfFirstElement());

        logger.info("Click on game and to the game’s page");
        mainPage.clickOnFirstGameInList();
        return listOfInformation;
    }
    public ArrayList<String> getTagsFromMainPage() {
        MainPage mainPage = new MainPage();
        ArrayList<String> listOfTags = new ArrayList<>(mainPage.getTextFromListOfTagsOfFirstElement());
        logger.info("tags from main page " + listOfTags);
        mainPage.clickOnFirstGameInList();
        return listOfTags;
    }
}

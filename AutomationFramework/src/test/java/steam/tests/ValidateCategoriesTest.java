package steam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steam.pages.MainPage;
import steam.steps.MainPageSteps;

import java.util.Arrays;
import java.util.List;

public class ValidateCategoriesTest extends BaseTest{
    private MainPageSteps mainPageSteps;
    @Test(description = "ST_ID 1: Verify that dropdown list on main page has correct categories")
    public void validateCategoriesTest() {
        MainPage mainPage = new MainPage();
        mainPage.hoverOnCategories();
        mainPageSteps = new MainPageSteps();
        List<String> listOfCategories = Arrays.asList("action", "rpg", "strategy");
        Assert.assertTrue(mainPageSteps.equalsListOfCategories(listOfCategories));
    }

}

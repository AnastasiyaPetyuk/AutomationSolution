package steam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steam.pages.MainPage;
import steam.steps.MainPageSteps;

public class ValidateCategoriesTest extends BaseTest{
    private MainPageSteps mainPageSteps;
    @Test
    public void validateCategoriesTest() {
        MainPage mainPage = new MainPage();
        mainPage.hoverOnCategories();
        mainPageSteps = new MainPageSteps();
        Assert.assertTrue(mainPageSteps.equalsListOfCategories());
    }

}

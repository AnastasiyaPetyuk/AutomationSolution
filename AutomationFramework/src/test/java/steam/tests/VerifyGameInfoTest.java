package steam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steam.models.GameInfo;
import steam.models.GameTags;
import steam.pages.MainPage;
import steam.steps.GamePageSteps;
import steam.steps.MainPageSteps;

public class VerifyGameInfoTest extends BaseTest{
    private MainPage mainPage = new MainPage();
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private GamePageSteps gamePageSteps = new GamePageSteps();
    @Test
    public void verifyGameInfoTest() {
        mainPage.scrollDownToLabelNewAndTrending();

        GameTags gameTagsFromMainPage = new GameTags(mainPageSteps.getTagsFromMainPage());
        GameTags gameTagsFromGamePage = new GameTags(gamePageSteps.getTagsFromGamePage());
        Assert.assertTrue(gameTagsFromMainPage.equals(gameTagsFromGamePage));
        mainPage.goToMainPage();
        GameInfo gameInfoFromMainPage = new GameInfo(mainPageSteps.getGameInfoFromMainPage());
        GameInfo gameInfoFromGamePage = new GameInfo(gamePageSteps.getGameInfoFromGamePage());
        Assert.assertTrue(gameInfoFromMainPage.equals(gameInfoFromGamePage));
    }
}

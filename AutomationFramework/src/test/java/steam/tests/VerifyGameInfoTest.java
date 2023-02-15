package steam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steam.models.GameInfo;
import steam.pages.MainPage;
import steam.steps.GamePageSteps;
import steam.steps.MainPageSteps;

public class VerifyGameInfoTest extends BaseTest{
    private MainPage mainPage = new MainPage();
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private GamePageSteps gamePageSteps = new GamePageSteps();
    @Test(description = "ST_ID 3: Verify that game info from the main page is the same as info on the game’s page")
    public void verifyGameInfoTest() {
        mainPage.scrollDownToLabelNewAndTrending();
        GameInfo gameInfoFromMainPage = mainPageSteps.getGameInfoFromMainPage().getGameInfo();
        GameInfo gameInfoFromGamePage = gamePageSteps.getGameInfoFromGamePage();
        Assert.assertTrue(gameInfoFromMainPage.equals(gameInfoFromGamePage));
    }
}

package steam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
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
        Assert.assertTrue((mainPageSteps.getTagsFromMainPage()).equals(gamePageSteps.getTagsFromGamePage()));
        mainPage.goToMainPage();
        Assert.assertTrue((mainPageSteps.getGameInfoFromMainPage()).equals(gamePageSteps.getGameInfoFromGamePage()));
    }
}

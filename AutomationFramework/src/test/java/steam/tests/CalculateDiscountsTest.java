package steam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steam.pages.MainPage;
import steam.pages.SpecialOffersPage;
import steam.steps.SpecialOffersPageSteps;

import java.time.Duration;

public class CalculateDiscountsTest extends BaseTest {
    private MainPage mainPage;
    private SpecialOffersPage specialOffersPage;
    @Test
    public void CalculateDiscountsTest() {
        mainPage = new MainPage();
        mainPage.hoverOnNewAndNoteworthy();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        mainPage.clickToSpecialOffers();
        specialOffersPage = new SpecialOffersPage();
        specialOffersPage.scrollDownToListOfOffers();
        Assert.assertTrue(new SpecialOffersPageSteps().validateCalculatingOfDiscounts());
    }
}


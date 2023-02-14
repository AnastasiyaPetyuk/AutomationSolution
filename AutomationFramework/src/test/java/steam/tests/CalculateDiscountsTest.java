package steam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steam.pages.MainPage;
import steam.pages.SpecialOffersPage;
import steam.steps.SpecialOffersPageSteps;

public class CalculateDiscountsTest extends BaseTest {
    private MainPage mainPage;
    private SpecialOffersPage specialOffersPage;
    @Test(description = "ST_ID 2: Verify that Special Offers page calculates discounts correctly")
    public void CalculateDiscountsTest() {
        mainPage = new MainPage();
        mainPage.hoverOnNewAndNoteworthy();
        mainPage.clickToSpecialOffers();
        specialOffersPage = new SpecialOffersPage();
        specialOffersPage.scrollDownToListOfOffers();
        Assert.assertTrue(new SpecialOffersPageSteps().validateCalculatingOfDiscounts());
    }
}


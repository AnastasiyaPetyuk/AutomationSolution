package steam.pages;

import framework.driver.Browser;
import framework.page.BasePage;
import framework.pageElements.Button;
import framework.pageElements.Label;
import org.openqa.selenium.By;

import java.time.Duration;


public class MainPage extends BasePage {
    protected final Label mainPageUniqueLabel = new Label(By.xpath("//div[contains(@class, 'capsule main_capsule')]"));
    private final Button categoriesButton = new Button(By.xpath("//a[contains(text(), 'Categories')]"));
    private final Button newAndNoteworthyButton = new Button(By.xpath("//a[contains(text(), 'New & Noteworthy')]"));
    private final Button specialOffersButton = new Button(By.xpath("//a[contains(text(), 'Special Offers')]"));
    private final Label newAndTrendingLabel = new Label(By.xpath("//div[@class=\"home_ctn tab_container\"]"));
    private final Button goToMainPageButton = new Button(By.xpath("//span[@id=\"logo_holder\"]"));

    public MainPage() {
        uniqueElement = mainPageUniqueLabel;
    }

    public void navigateToCategories() {
        categoriesButton.moveCursorToElement();

    }
    public void navigateToNewAndNoteworthy() {
        newAndNoteworthyButton.moveCursorToElement();
        Browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }
    public void clickToSpecialOffers() {
        specialOffersButton.click();
    }

    public void scrollDownToLabelNewAndTrending() {
        newAndTrendingLabel.scrollDownToElement();
    }

    public void goToMainPage() {
        goToMainPageButton.click();
    }
}

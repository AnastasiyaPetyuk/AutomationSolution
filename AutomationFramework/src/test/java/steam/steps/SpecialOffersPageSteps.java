package steam.steps;

import framework.pageElements.ListOfElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.logging.Logger;

public class SpecialOffersPageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());
    private final ListOfElements<WebElement> listOfGameSale = new ListOfElements<>(By.xpath("//div[contains(@class,'salepreviewwidgets_StoreSaleWidgetRight')]//div[contains(@class, \"StoreSaleDiscountBox\")]"));
    private final ListOfElements<WebElement> listOfStartedPrice = new ListOfElements<>(By.xpath("//div[contains(@class,'salepreviewwidgets_StoreSaleWidgetRight')]//div[contains(@class, \"StoreOriginalPrice\")]"));
    private final ListOfElements<WebElement> listOfCurrentPrice = new ListOfElements<>(By.xpath("//div[contains(@class,'salepreviewwidgets_StoreSaleWidgetRight')]//div[contains(@class, \"StoreSalePriceBox\")]"));


    public boolean validateCalculatingOfDiscounts() {
        logger.info("convert list of WebElements to ArrayList");
        ArrayList<String> stringListOfSales = new ArrayList<>(listOfGameSale.convertListOfWebElementsToListOfStrings());
        ArrayList<String> stringListOfStartedPrice = new ArrayList<>(listOfStartedPrice.convertListOfWebElementsToListOfStrings());
        ArrayList<String> stringListOfCurrentPrice = new ArrayList<>(listOfCurrentPrice.convertListOfWebElementsToListOfStrings());

        logger.info("validate discounts");
        for(int i = 0; i < 12; i++) {
            logger.info("discount of " + (i+1) + " game" );
            double sale = Double.parseDouble(stringListOfSales.get(i).toString().replaceAll("[^0-9]", ""));
            double startedPrice = Double.parseDouble(stringListOfStartedPrice.get(i).toString().replaceAll("[^0-9.,]", "").replaceAll(",", "."));
            String currentPrice = stringListOfCurrentPrice.get(i).toString().replaceAll("[^0-9.,]", "").replaceAll(",", ".");

            double trueCurrentPriceDouble = (double) Math.round((startedPrice*(1-sale/100)) * 100) / 100;
            String trueCurrentPrice = String.format("%.2f", trueCurrentPriceDouble);

            if (trueCurrentPrice.equals(currentPrice)) {
                logger.warning("incorrect price");
                return false;
            }
        }
        return true;
    }
}

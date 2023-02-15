package steam.steps;

import framework.constants.Regex;
import steam.pages.SpecialOffersPage;

import java.util.ArrayList;
import java.util.logging.Logger;

public class SpecialOffersPageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());

    public boolean validateCalculatingOfDiscounts() {
        logger.info("convert list of WebElements to ArrayList");
        SpecialOffersPage specialOffersPage = new SpecialOffersPage();
        ArrayList<String> stringListOfSales = new ArrayList<>(specialOffersPage.getTextFromListOfGameSale());
        ArrayList<String> stringListOfStartedPrice = new ArrayList<>(specialOffersPage.getTextFromListOfStartedPrice());
        ArrayList<String> stringListOfCurrentPrice = new ArrayList<>(specialOffersPage.getTextFromListOfCurrentPrice());

        logger.info("validate discounts");
        for(int i = 0; i < 12; i++) {
            logger.info("discount of " + (i+1) + " game" );
            double sale = Double.parseDouble(stringListOfSales.get(i).toString().replaceAll(Regex.onlyNumberRegex, ""));
            double startedPrice = Double.parseDouble(stringListOfStartedPrice.get(i).toString().replaceAll(Regex.onlyNumberDotCommaRegex, "").replaceAll(",", "."));
            String currentPrice = stringListOfCurrentPrice.get(i).toString().replaceAll(Regex.onlyNumberDotCommaRegex, "").replaceAll(",", ".");

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

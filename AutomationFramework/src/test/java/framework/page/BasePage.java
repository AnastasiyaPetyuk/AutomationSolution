package framework.page;

import framework.pageElements.BaseElement;

public abstract class BasePage {
    protected BaseElement uniqueElement;
    public boolean isPageDisplayed () {
        return this.uniqueElement.isDisplayed();
    }
}

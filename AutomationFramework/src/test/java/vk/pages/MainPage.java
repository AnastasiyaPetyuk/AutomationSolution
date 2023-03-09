package vk.pages;

import framework.pageElements.Button;
import framework.pageElements.Label;
import org.openqa.selenium.By;

public class MainPage {
    Label enterEmailLabel = new Label(By.id("index_email"));
    Button enterButton = new Button(By.xpath("//button[contains(@class, 'VkIdForm__signInButton')]"));
    Label passwordlabel = new Label(By.name("password"));
    Button continueButton = new Button(By.xpath("//span[@class='vkuiButton__in']"));
    Label myPageButton = new Label(By.xpath("//span[@class='LeftMenu__itemLabel'][contains(text(), 'Моя страница')]"));
    Label textFromLastPost = new Label(By.xpath("//div[@class='wall_post_text zoom_text']"));

    public void enterEmail(String email) {
        enterEmailLabel.sendText(email);
        enterButton.click();
    }
    public void enterPasswordAndContinue(String password) {
        passwordlabel.sendText(password);
        continueButton.click();
    }
    public void goToMyPage() {
        myPageButton.click();
    }
    public String getTextFromLastPost() {
        return textFromLastPost.getText();
    }


}

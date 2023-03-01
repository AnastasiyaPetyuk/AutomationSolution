package vk.tests;

import framework.utils.GetProperties;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import vk.steps.MainPageSteps;

public class AddPostFromApiTest extends BaseTest {
    MainPageSteps mainPageSteps = new MainPageSteps();
    private String postId;
    @Test
    public void apiVkPostTextOnTheWall() {
        postId = mainPageSteps.createPost();

        String email = GetProperties.getProperties("vkApi", "email");
        String password = GetProperties.getProperties("vkApi", "password");
        mainPageSteps.authorization(email, password);
        String postTextFromUI = mainPageSteps.goToMyPageAndGetTextFromLastPost();

        Assert.assertEquals(postTextFromUI, GetProperties.getProperties("vkApi", "message"));
    }
    @AfterTest
    public void afterTestApiVkPostTextOnTheWall() {
        mainPageSteps.deletePost(postId);
    }

}

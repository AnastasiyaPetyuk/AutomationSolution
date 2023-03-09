package vk.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import vk.api.Post;
import vk.steps.MainPageSteps;

import static vk.api.constants.*;
import static vk.api.constants.VK_API_VERSION;

public class AddPostFromApiTest extends BaseTest {
    MainPageSteps mainPageSteps = new MainPageSteps();
    private String postId;
    Post post = new Post(ACCESS_TOKEN, OWNER_ID, MESSAGE, VK_API_VERSION);

    @Test
    public void apiVkPostTextOnTheWall() {
        mainPageSteps.createPost(post);
        mainPageSteps.authorization(EMAIL, PASSWORD);
        String postTextFromUI = mainPageSteps.goToMyPageAndGetTextFromLastPost();

        Assert.assertEquals(postTextFromUI, MESSAGE);
    }
    @AfterTest
    public void afterTestApiVkPostTextOnTheWall() {
        mainPageSteps.deletePost(post);
    }

}

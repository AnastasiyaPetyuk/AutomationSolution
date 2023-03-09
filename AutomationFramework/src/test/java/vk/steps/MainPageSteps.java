package vk.steps;

import vk.api.PostController;
import vk.api.Post;
import vk.pages.MainPage;

public class MainPageSteps {
    MainPage mainPage = new MainPage();
    PostController postController = new PostController();

    public void authorization(String email, String password) {
        mainPage.enterEmail(email);
        mainPage.enterPasswordAndContinue(password);
    }

    public void createPost(Post post) {
        postController.createPost(post);
    }
    public String goToMyPageAndGetTextFromLastPost() {
        mainPage.goToMyPage();
        return mainPage.getTextFromLastPost();
    }


    public void deletePost(Post post) {
        postController.deletePost(post);
    }

}

package vk.steps;

import framework.utils.GetProperties;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import vk.pages.MainPage;

public class MainPageSteps {
    private String ownerId = GetProperties.getProperties("vkApi", "owner_id");
    private String accessToken = GetProperties.getProperties("vkApi", "access_token");
    private String vkApiVersion = GetProperties.getProperties("vkApi", "v");
    private String postThisTextOnTheWall = GetProperties.getProperties("vkApi", "message");
    MainPage mainPage = new MainPage();

    public void authorization(String email, String password) {
        mainPage.enterEmail(email);
        mainPage.enterPasswordAndContinue(password);
    }

    public String createPost() {
        String postId;
        RestAssured.baseURI = "https://api.vk.com/method/wall.post?";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("owner_id", ownerId);
        httpRequest.param("message", postThisTextOnTheWall);
        httpRequest.param("access_token", accessToken);
        httpRequest.param("v", vkApiVersion);
        Response response = httpRequest.request(Method.POST);
        String responseBody = response.body().asString();
        JSONObject myResponseBody = new JSONObject(responseBody);
        JSONObject responseObject = (JSONObject) myResponseBody.get("response");
        postId = responseObject.get("post_id").toString();
        return postId;
//        postIdWithOwnerId = ownerId + "_" + postId;
//        Assert.assertEquals(200, response.getStatusCode());
    }
    public String goToMyPageAndGetTextFromLastPost() {
        mainPage.goToMyPage();
        return mainPage.getTextFromLastPost();
    }


    public void deletePost(String post_id) {
        RestAssured.baseURI = "https://api.vk.com/method/wall.delete?";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("owner_id", ownerId);
        httpRequest.param("post_id", post_id);
        httpRequest.param("access_token", accessToken);
        httpRequest.param("v", vkApiVersion);
        Response response = httpRequest.request(Method.DELETE);
    }

}

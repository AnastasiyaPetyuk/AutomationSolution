package vk.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import java.util.HashMap;
import java.util.Map;

import static vk.api.constants.*;

public class PostController {

    public String createPost(Post post) {
        Map<String, String> postInfo = new HashMap<>();
        postInfo.put("owner_id", post.getOwner_id());
        postInfo.put("message", post.getMessage());
        postInfo.put("access_token", post.getAccess_token());
        postInfo.put("v", post.getV());

        RestAssured.baseURI = BASE_URl + "/wall.post?";
        String postIdFromPostRequest = RestAssured.given()
                .params(postInfo).
                request(Method.POST).
                body().asString();
        post.setPost_id(postIdFromPostRequest);
        return post.getPost_id();
    }

    public void deletePost(Post post) {
        Map<String, String> deletePostBody = new HashMap<>();
        deletePostBody.put("owner_id", post.getOwner_id());
        deletePostBody.put("post_id", post.getPost_id());
        deletePostBody.put("access_token", post.getAccess_token());
        deletePostBody.put("v", post.getV());
        RestAssured.given()
                .baseUri(BASE_URl + "/wall.delete")
                .body(deletePostBody)
                .delete();
    }
}

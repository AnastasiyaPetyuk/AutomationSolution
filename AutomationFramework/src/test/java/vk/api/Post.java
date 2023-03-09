package vk.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private String access_token;
    private String owner_id;
    private String message;
    private String post_id;
    private String v;
    public Post(String access_token, String owner_id, String message, String v) {
        this.access_token = access_token;
        this.owner_id = owner_id;
        this.message = message;
        this.v = v;
    }
}

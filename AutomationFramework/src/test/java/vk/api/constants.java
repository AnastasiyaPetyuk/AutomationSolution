package vk.api;

import framework.utils.GetProperties;

public class constants {
    public static final String OWNER_ID = GetProperties.getProperties("vkApi", "owner_id");
    public static final String ACCESS_TOKEN = GetProperties.getProperties("vkApi", "access_token");
    public static final String VK_API_VERSION = GetProperties.getProperties("vkApi", "v");
    public static final String MESSAGE = GetProperties.getProperties("vkApi", "message");
    public static final String BASE_URl = GetProperties.getProperties("vkApi", "baseURL");
    public static final String EMAIL = GetProperties.getProperties("vkApi", "email");
    public static final String PASSWORD = GetProperties.getProperties("vkApi", "password");

}

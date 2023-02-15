package framework.utils;

import java.util.ResourceBundle;

public class GetProperties {
    public static String getProperties (String propertyFile, String key) {
        ResourceBundle rb = ResourceBundle.getBundle(propertyFile);
        return rb.getString(key);
    }
}

package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserPropertiesManager {

    /**
     *
     * @return user properties object
     */
    public static Properties getUserProperty(){
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("user.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}

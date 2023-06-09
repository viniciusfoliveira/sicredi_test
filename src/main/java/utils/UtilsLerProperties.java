package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class UtilsLerProperties {


    private UtilsLerProperties(){}

    public static String getProperties(String valor) {
        try {
            Properties properties = new Properties();
            FileInputStream propertiesFile = new FileInputStream("./src/main/resources/config.properties");
            properties.load(propertiesFile);
            return properties.getProperty(valor);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid property file path:");
        }
    }
}

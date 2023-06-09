package utils;

public class UtilsAmbiente {

    public static String getAmbiente() {

        if (System.getProperty("env").equalsIgnoreCase("hom"))
            return UtilsLerProperties.getProperties("api.url.hom");

        return UtilsLerProperties.getProperties("api.url.dev");
    }
}

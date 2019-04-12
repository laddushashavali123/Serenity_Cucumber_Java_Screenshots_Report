package com.lumbela.SerenityCucumberTemplate.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import static com.lumbela.SerenityCucumberTemplate.utils.Constant.CONFIG_PROPERTIES_DIRECTORY;

public class Utilities {

    /**
     * load properties file
     *
     * @throws IOException
     */
    public static Properties loadProperties() {
        Properties properties = null;
        if (properties == null) {
            try {
                properties = new Properties();
                FileInputStream fs = new FileInputStream(CONFIG_PROPERTIES_DIRECTORY);
                properties.load(fs);
            } catch (Exception e) {
                e.printStackTrace();
                // report
            }
        }
        return properties;
    }
    /**
     * Method to append random nos to email
     *
     * @return
     */
    public static String generateRandomEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(99999);
        String EMAIL = "username" + Integer.toString(randomInt) + "@gmail.com";
        System.out.println(EMAIL);
        return EMAIL;

    }


}

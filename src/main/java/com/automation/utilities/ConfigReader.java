package com.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String DEFAULT_APP_FILE = "src/test/resources/application.properties";
    private static String environment;

    static {
        try {
            properties = new Properties();
            environment = System.getProperty("env", "qa");
            String configPath = String.format("src/test/resources/config-%s.properties", environment);
            FileInputStream inputStream;
            inputStream = new FileInputStream(configPath);
            properties.load(inputStream);
            inputStream = new FileInputStream(DEFAULT_APP_FILE);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key, null);
    }
}

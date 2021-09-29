package com.eldarian.pureselenium;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public enum Configs {
    BASE_URL("base_url"),
    BROWSER("browser");

    private final String value;

    Configs(String key) {
        Properties config = new Properties();
        try {
            config.load(new FileReader("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.value = config.getProperty(key);
    }

    public String getValue() {
        return value;
    }
}

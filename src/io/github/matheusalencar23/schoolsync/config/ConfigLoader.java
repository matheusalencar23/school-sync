package io.github.matheusalencar23.schoolsync.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    public static String getProperty(String key) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/application.properties")) {
            properties.load(fis);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo de propriedades: " + e.getMessage());
            return null;
        }
    }
}

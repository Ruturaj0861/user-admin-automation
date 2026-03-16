package config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {

    static Dotenv dotenv = Dotenv.load();

    public static String get(String key){
        return dotenv.get(key);
    }

}
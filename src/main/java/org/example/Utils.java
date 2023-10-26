package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class Utils {
    private static Dotenv dotenv = Dotenv.load();
   public static String URL = dotenv.get("URL");
   public static String PASSWORD =dotenv.get("PASSWORD");
   public static String USER = dotenv.get("USER");
}

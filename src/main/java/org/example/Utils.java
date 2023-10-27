package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class Utils {
    private static Dotenv dotenv = Dotenv.load();
   public static String PG_URL = dotenv.get("PG_URL");
   public static String PG_PASSWORD =dotenv.get("PG_PASSWORD");
   public static String PG_USER = dotenv.get("PG_USER");
}

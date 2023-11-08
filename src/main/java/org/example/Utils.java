package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class Utils {

        private static final Dotenv dotenv = inProduction() ? null : Dotenv.load();
        public static final String PG_URL = inProduction() ? System.getenv("PG_URL") : dotenv != null ? dotenv.get("PG_URL") : null;
        public static final String PG_PASSWORD = inProduction() ? System.getenv("PG_PASSWORD") : dotenv != null ? dotenv.get("PG_PASSWORD") : null;
        public static final String PG_USER =  inProduction() ? System.getenv("PG_USER") : dotenv != null ? dotenv.get("PG_USER") : null;

    public static boolean inProduction(){
        String port=System.getenv("PORT");
        return port != null;
    }
}

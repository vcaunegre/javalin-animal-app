package org.example;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.*;

public class Utils {

        private static Dotenv dotenv = inProduction() ? null : Dotenv.load();
        public static String PG_URL = inProduction() ? System.getenv("PG_URL") : dotenv.get("PG_URL") ;
        public static String PG_PASSWORD = inProduction() ? System.getenv("PG_PASSWORD") : dotenv.get("PG_PASSWORD") ;
        public static String PG_USER =  inProduction() ? System.getenv("PG_USER") : dotenv.get("PG_USER") ;

    public static boolean inProduction(){
        String port=System.getenv("PORT");
        return port != null;
    }
}

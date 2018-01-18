package utils;

import tests.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

   public static Properties loadPropertiesFromConfig(String path) {

      BaseTest.logger.info("Loading data from " + path);

      InputStream input = null;
      Properties properties = new Properties();
      try {
         input = new FileInputStream(path);
         properties.load(input);
         BaseTest.logger.info("Loading data from " + path + " - SUCCESS");
      } catch (IOException ex) {
         BaseTest.logger.info("Loading data from " + path + " - ERROR");
         ex.printStackTrace();
      } finally {
         if (input != null) {
            try {
               input.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
      return properties;
   }
}

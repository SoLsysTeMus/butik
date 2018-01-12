package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
   public static Properties loadPropertiesFromConfig(String path) {
      InputStream input = null;
      Properties temp = new Properties();
      try {
         input = new FileInputStream(path);
         temp.load(input);
      } catch (IOException ex) {
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
      return temp;
   }
}

package utils;

import com.codeborne.selenide.Configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AllureEnvironmentUtils {

   public static void create() {

      try (BufferedWriter writer = new BufferedWriter(new FileWriter("/home/sol/myprojects/butik/butik/build/allure-results/environment.properties"))) {
         writer.write("Browser=" + Configuration.browser + "\n");
         writer.write("URL=" + Configuration.baseUrl + "\n");
      } catch (IOException e) {
         System.out.println("IO problem when writing allure properties file");
      }
   }

}
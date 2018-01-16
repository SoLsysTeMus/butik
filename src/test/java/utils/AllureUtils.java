package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.*;
import java.util.Properties;

public class AllureUtils {

   public static void createEnvironmentProperties() {

      try (BufferedWriter writer = new BufferedWriter(new FileWriter("build/allure-results/environment.properties"))) {
         writer.write("Browser=" + Configuration.browser + "\n");
         writer.write("URL=" + Configuration.baseUrl + "\n");
      } catch (IOException e) {
         System.out.println("IO problem when writing allure properties file");
      }
   }

   public static void createPropertiesFile() {

      try (PrintWriter writer = new PrintWriter(new FileWriter("build/allure-results/prop.properties"))) {
         Properties p = System.getProperties();
         p.list(writer);
      } catch (IOException e) {
         System.out.println("IO problem when writing allure properties file");
      }
   }

   @Attachment(value = "Screenshot", type = "image/png")
   static byte[] failScreenshot() throws IOException {
      File screenshot = Screenshots.takeScreenShotAsFile();
      return Files.toByteArray(screenshot);
   }
}
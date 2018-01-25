package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static tests.BaseTest.logger;
import static utils.AllureUtils.failScreenshot;

public class AllureListeners implements ITestListener {

   @Override
   public void onTestStart(ITestResult result) {
      logger.info("Start   test - " + result.getName());
   }

   @Override
   public void onTestSuccess(ITestResult result) {
      logger.info("Success test - " + result.getName());
   }

   @Override
   public void onTestFailure(ITestResult result) {
      logger.error("FAIL    test - " + result.getName() + " - " + result.getThrowable().getMessage());
      try {
         failScreenshot();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void onTestSkipped(ITestResult result) {
      logger.info("Skipped test - " + result.getName());
   }

   @Override
   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

      try {
         failScreenshot();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   @Override
   public void onStart(ITestContext context) {
      logger.info("Tests start " + context.getStartDate());
   }

   @Override
   public void onFinish(ITestContext context) {
      AllureUtils.createEnvironmentProperties();
      logger.info("Tests finished " + context.getEndDate());
   }

}

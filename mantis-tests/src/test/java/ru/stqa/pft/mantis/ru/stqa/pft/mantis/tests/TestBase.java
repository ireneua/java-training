package ru.stqa.pft.mantis.ru.stqa.pft.mantis.tests;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.ru.stqa.pft.mantis.appmanager.ApplicationManager;

/**
 * Created by irener on 7/27/16
 */

public class TestBase {

  protected static final ApplicationManager app =
          new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));


  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}

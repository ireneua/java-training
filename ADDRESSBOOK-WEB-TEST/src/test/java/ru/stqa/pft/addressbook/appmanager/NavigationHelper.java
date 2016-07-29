package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by irener on 7/29/16.
 */
public class NavigationHelper {
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd){
    this.wd = wd;
  }

  public void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}

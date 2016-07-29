package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by irener on 7/29/16.
 */
public class NavigationHelper extends HelperBase{


  public NavigationHelper(FirefoxDriver wd){
    super(wd);
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }
}

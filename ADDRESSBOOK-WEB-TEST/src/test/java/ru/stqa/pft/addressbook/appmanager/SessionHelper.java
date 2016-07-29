package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by irener on 7/29/16.
 */
public class SessionHelper extends HelperBase{


  public SessionHelper(FirefoxDriver wd) {

    super(wd);
  }

  public void login(String username, String password) {
    type(By.name("user"),username);
    type(By.name("pass"), password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));

  }
}

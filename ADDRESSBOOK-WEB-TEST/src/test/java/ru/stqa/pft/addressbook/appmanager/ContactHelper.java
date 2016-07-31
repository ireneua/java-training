package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by irener on 7/31/16.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactData(ContactData contactData) {

    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("home"), contactData.getHome());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[5]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[5]")).click();
    }
    type(By.name("byear"), contactData.getYear());
    click(By.xpath("//div[@id='content']/form/input[21]"));

  }

  public void selectContact(){
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      wd.findElement(By.name("selected[]")).click();
    }
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void editContact(){
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void deleteContact(){
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void saveUpdatedContact() {
    click(By.name("update"));
  }
}

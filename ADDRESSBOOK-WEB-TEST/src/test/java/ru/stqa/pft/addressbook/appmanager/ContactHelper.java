package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irener on 7/31/16.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
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

  public void selectContact(int i) {
    wd.findElements(By.name("selected[]")).get(i).click();
  }

  public void editContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void saveUpdatedContact() {
    click(By.name("update"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactData((new ContactData("Johny", "Dow", "Po", null, "developer", "Po-dev", null, "indo@test.com", "indo_double@test.com", "indo_double@test.com", "1988")));
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      ContactData contact = new ContactData(id, firstName, "bla", lastName, null, null, null, null,null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}

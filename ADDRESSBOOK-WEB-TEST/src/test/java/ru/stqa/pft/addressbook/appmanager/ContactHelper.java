package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import  java.util.Set;

/**
 * Created by irener on 7/31/16.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactData(ContactData contactData) {

    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("home"), contactData.getAddress());
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

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactData(contact);
    contactCache = null;
    returnToHomePage();
  }

  public void editContact(int id) {
    wd.findElement((By.cssSelector("a[href =\"edit.php?id=" + id + "\"]"))).click();
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void delete(ContactData contactData) {
    selectContactById(contactData.getId());
    deleteContact();
    contactCache = null;
    returnToHomePage();
  }

  public void modifyContact(ContactData contact) {
    selectContactById(contact.getId());
    editContact(contact.getId());
    fillContactData(contact);
    saveUpdatedContact();
    contactCache = null;
    returnToHomePage();
  }

  private void selectContactById(int id) {
    wd.findElement((By.cssSelector("a[href*='edit.php?id=" + id + "']"))).click();
  }

  private void  clickContactImageById(int id){
    wd.findElement((By.cssSelector("a[href*='view.php?id=" + id + "']"))).click();
  }

  public void saveUpdatedContact() {
    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> contactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData()
              .withName("Judi").withLastName("Jaster").withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
              .withYear("1987");
      contacts.add(contact);
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts allConacts() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String[] phones = cells.get(5).getText().split("\n");

      contactCache.add(new ContactData()
              .withName(firstName).withLastName(lastName)
              .withId(id).withMobileNumber(phones[1])
              .withHomeNumber(phones[0]).withWorkNumber(phones[2]));
    }
    return new Contacts(contactCache);
  }

  public Set<ContactData> all(){
    Set<ContactData> contacts = new HashSet<>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();

      contacts.add(new ContactData()
              .withName(firstName).withLastName(lastName)
              .withId(id).withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return contacts;

  }

  public ContactData infoFromEditForm(ContactData contact) {
    selectContactById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    returnToHomePage();
    return new ContactData().withId(contact.getId()).withName(firstName).withLastName(lastName).withHomeNumber(home)
            .withMobileNumber(mobile).withWorkNumber(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }


  public ContactData infoFromViewForm(ContactData contact){
    clickContactImageById(contact.getId());
    String allContactData = wd.findElement((By.id("content"))).getText();
    returnToHomePage();
    return new ContactData().withAllContactInfo(allContactData);
  }
}

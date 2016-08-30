package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class NewContactCreationTests extends TestBase {

  /*@DataProvider
  public Iterator<Object[]> validContacts(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new ContactData().withName("test1")
            .withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
            .withYear("1987").withHomeNumber("6666").withMobileNumber("999").withWorkNumber("777")});
    list.add(new Object[]{new ContactData().withName("test2")
            .withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
            .withYear("1987").withHomeNumber("6666").withMobileNumber("999").withWorkNumber("777")});
    list.add(new Object[]{new ContactData().withName("test3")
            .withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
            .withYear("1987").withHomeNumber("6666").withMobileNumber("999").withWorkNumber("777")});
    return list.iterator();
  }*/


  @Test(dataProvider = "validContacts")

  public void testNewContactCreation() {

    app.goTo().homePage();
    Contacts before = app.contact().allConacts();
    File photo = new File("src/test/resources/123.jpg");
    ContactData contact = (new ContactData()
            .withName("Judi").withLastName("Jaster").withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
            .withYear("1987").withHomeNumber("6666").withMobileNumber("999").withWorkNumber("777").withPhoto(photo));
    app.contact().createContact(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after =  app.contact().allConacts();

    assertThat(after, equalTo(before.withAdded(contact.withId((after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))));


  }

}

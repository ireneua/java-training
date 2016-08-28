package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class NewContactCreationTests extends TestBase {

  @Test
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

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by irener on 7/31/16.
 */
public class ContactModificationsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsForContacts() {

    if (app.db().contacts().size() == 0){
      app.goTo().homePage();
      app.contact().createContact(new ContactData()
              .withName("Judi").withLastName("Jaster").withCompany("CocaCola").withTitle("Dev").withEmail("indo8@test.com").withEmail2("indo_doublex@test.com")
              .withYear("1937"));
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    File photo = new File("src/test/resources/123.jpg");
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withLastName("Tresh").withName("Mashaaa")
            .withEmail("result@test.com").withHomeNumber("37937473").withPhoto(photo);
    app.goTo().homePage();
    app.contact().modifyContact(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size()));
    Contacts after = app.db().contacts();

    assertEquals(before.size(), after.size());

    assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));

    verifyContactsInUI();
  }

}

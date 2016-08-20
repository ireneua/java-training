package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by irener on 7/31/16.
 */
public class ContactModificationsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsForContacts() {
    app.goTo().homePage();
    if (app.contact().contactList().size()==0) {
      app.contact().createContact(new ContactData()
              .withName("Judi").withLastName("Jaster").withCompany("CocaCola").withTitle("Dev").withEmail("indo8@test.com").withEmail2("indo_doublex@test.com")
              .withYear("1937"));
    }
  }

  @Test
  public void testContactModification() {

      Set<ContactData> before = app.contact().allConacts();
      ContactData modifiedContact = before.iterator().next();
      ContactData contact = new ContactData().withId(modifiedContact.getId())
              .withLastName("Tresh").withName("Masha")
              .withEmail("result@test.com");

      app.contact().modifyContact(contact);
      Set<ContactData> after = app.contact().allConacts();
      Assert.assertEquals(after.size(), before.size());

      before.remove(modifiedContact);
      before.add(contact);
      Assert.assertEquals(after, before);


  }
}

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by irener on 7/31/16.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().contactList().size() == 0) {
      app.contact().createContact(new ContactData()
              .withName("Judi").withLastName("Jaster").withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
              .withYear("1987"));
    }
  }

  @Test
  public void testDeleteContact() {

    Contacts before = app.contact().allConacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().allConacts();
    Assert.assertEquals(after.size(), before.size() - 1);
    assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(after, before);
    assertThat(after, equalTo(before.withoutAdded(deletedContact)));
  }


}

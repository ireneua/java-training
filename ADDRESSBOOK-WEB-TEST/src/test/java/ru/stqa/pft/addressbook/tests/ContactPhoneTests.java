package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by irener on 8/21/16.
 */
public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditionsForContacts() {
    app.goTo().homePage();
    if (app.contact().contactList().size() == 0) {
      app.contact().createContact(new ContactData()
              .withName("Judi").withLastName("Jaster").withCompany("CocaCola").withTitle("Dev").withEmail("indo8@test.com").withEmail2("indo_doublex@test.com")
              .withYear("1937"));
    }
  }

  @Test(enabled = true)
  public void testContactPhones(){
    app.goTo().homePage();
    ContactData contact = app.contact().allConacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomeNumber(), equalTo(contactInfoFromEditForm.getHomeNumber()));
    assertThat(contact.getWorkNumber(), equalTo(contactInfoFromEditForm.getWorkNumber()));
    assertThat(contact.getMobileNumber(), equalTo(contactInfoFromEditForm.getMobileNumber()));
  }
}

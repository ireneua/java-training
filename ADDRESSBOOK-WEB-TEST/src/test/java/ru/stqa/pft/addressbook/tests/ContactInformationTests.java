package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by irener on 8/24/16.
 */
public class ContactInformationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsForContacts() {
    app.goTo().homePage();
    if (app.contact().contactList().size() == 0) {
      app.contact().createContact(new ContactData()
              .withName("Judi").withLastName("Jaster").withCompany("CocaCola").withTitle("Dev").withEmail("indo8@test.com").withEmail2("indo_doublex@test.com")
              .withYear("1937"));
    }
  }

  @Test
  public void testAllContactInfo(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contactInfoFromViewForm.getAllContactData(), equalTo(mergeContactData(contactInfoFromEditForm)));


  }

  private String mergeContactData(ContactData contact) {
      if (!(contact.getHomeNumber().equals(""))) {
        contact.withHomeNumber("H: " + contact.getHomeNumber());
      }
      if (!(contact.getMobileNumber().equals(""))) {
        contact.withMobileNumber("M: " + contact.getMobileNumber());
      }
      if (!(contact.getWorkNumber().equals(""))) {
        contact.withWorkNumber("W: " + contact.getWorkNumber());
      }
      return Arrays.asList(contact.getName() + " " + contact.getLastname() + "\n" + contact.getAddress() + "\n",
              contact.getHomeNumber(), contact.getMobileNumber(), contact.getWorkNumber())
              .stream().filter((s) -> !s.equals(""))
              .collect(Collectors.joining("\n"));

  }

  }


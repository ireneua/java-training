package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

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
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomeNumber(), contact.getMobileNumber(), contact.getWorkNumber())
      .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}

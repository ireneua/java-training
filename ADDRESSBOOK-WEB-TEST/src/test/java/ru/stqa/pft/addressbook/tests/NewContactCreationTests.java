package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() {

    app.goTo().homePage();
    Contacts before = app.contact().allConacts();
    ContactData contact = (new ContactData()
            .withName("Judi").withLastName("Jaster").withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
            .withYear("1987"));
    app.contact().createContact(contact);
    Contacts after = app.contact().allConacts();
    assertThat(after.size(), equalTo(before.size() + 1));
    contact.withId((after.stream().mapToInt((g) -> g.getId()).max().getAsInt()));

    assertThat(after, equalTo(before.withAdded(contact)));


  }

}

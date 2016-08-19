package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;


public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() {

    app.goTo().homePage();
    Set<ContactData> before = app.contact().allConacts();
    ContactData contact = (new ContactData()
            .withName("Judi").withLastName("Jaster").withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
            .withYear("1987"));
    app.contact().createContact(contact);
    Set<ContactData> after = app.contact().allConacts();
    Assert.assertEquals(before.size() + 1, after.size());
    contact.withId((after.stream().mapToInt((g) -> g.getId()).max().getAsInt()));

    before.add(contact);
    Assert.assertEquals(before, after);


  }

}

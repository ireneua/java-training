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
    app.contact().initContactCreation();
    ContactData contact = (new ContactData()
            .withName("Judi").withLastName("Jaster").withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
            .withYear("1987"));
    app.contact().fillContactData(contact);
    app.contact().returnToHomePage();
    Set<ContactData> after = app.contact().allConacts();
    contact.withId((after.stream().mapToInt((g) -> g.getId()).max().getAsInt()));

    before.add(contact);
    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    /*Comparator<? super ContactData> byId = (Comparator<ContactData>) (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);*/
    Assert.assertEquals(before, after);

  }

}

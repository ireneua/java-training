package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
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

  @Test (enabled = false)
  public void testContactModification() {

    Set<ContactData> before = app.contact().allConact();
    app.contact().editContact(before.size() - 1);
    //int id = before.get(before.size() - 1).getId();
    /*ContactData contact = new ContactData()
            .withId(id).withName("Judi").withLastName("Jaster").withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
            .withYear("1987");
    app.contact().fillContactData(contact);
    app.contact().saveUpdatedContact();
    app.contact().returnToHomePage();
    Set<ContactData> after = app.contact().allConact();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    /* old version
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
     */
    /*Comparator<? super ContactData> byId = (Comparator<ContactData>) (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);*/
    /*Assert.assertEquals(before, after);
    */
  }
}

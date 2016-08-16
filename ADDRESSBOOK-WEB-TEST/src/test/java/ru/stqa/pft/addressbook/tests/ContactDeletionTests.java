package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by irener on 7/31/16.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().conactList().size() == 0) {
      app.contact().createContact(new ContactData("Johny", "Dow", "Po", null, "developer", "Po-dev", null, "indo@test.com8", "indo_double@test.com", "indo8_double@test.com", "1978"));
    }
  }

  @Test
  public void testDeleteContact() {

    List<ContactData> before = app.contact().conactList();
    app.contact().delete(before);
    List<ContactData> after = app.contact().conactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }


}

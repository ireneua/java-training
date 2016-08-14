package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by irener on 7/31/16.
 */
public class ContactModificationsTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Johny", "Dow", "Po", null, "developer", "Po-dev", null, "indo@test.com8", "indo_double@test.com", "indo8_double@test.com", "1978"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactData(new ContactData("Judi", "Jaster", "Ko", "pro", "developer", "Po-dev", "USA", "indo6@test.com", "indo_doublex@test.com", "indo_doublex@test.com", "1967"));
    app.getContactHelper().saveUpdatedContact();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}

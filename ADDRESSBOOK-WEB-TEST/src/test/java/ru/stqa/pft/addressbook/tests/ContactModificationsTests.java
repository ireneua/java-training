package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by irener on 7/31/16.
 */
public class ContactModificationsTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactData(new ContactData("Judi", "Jaster", "Ko", "pro", "developer", "Po-dev", "USA", "indo6@test.com", "indo_doublex@test.com", "indo_doublex@test.com", "1967"));
    app.getContactHelper().saveUpdatedContact();
    app.getContactHelper().returnToHomePage();
  }
}

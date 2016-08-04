package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() {

    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactData((new ContactData("Johny", "Dow", "Po", null, "developer", "Po-dev", null, "indo@test.com", "indo_double@test.com", "indo_double@test.com", "1986")));
    app.getContactHelper().returnToHomePage();
  }

}

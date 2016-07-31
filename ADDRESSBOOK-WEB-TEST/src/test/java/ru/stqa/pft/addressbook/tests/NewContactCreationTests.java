package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() {

    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactData((new ContactData("John", "Borisik", "Po", "popo", "developer", "Po-dev", "India", "indo@test.com", "indo_double#test.com", "indo_double@test.com", "1986")));
    app.getContactHelper().returnToHomePage();
  }

}

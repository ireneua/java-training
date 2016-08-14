package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() {

    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactData((new ContactData("Johny", "Dow", "Po", null, "developer", "Po-dev", null, "indo@test.com", "indo_double@test.com", "indo_double@test.com", "1988")));
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}

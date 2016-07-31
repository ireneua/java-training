package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by irener on 7/31/16.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactModification(){

    app.getContactHelper().returnToHomePage();

  }
}

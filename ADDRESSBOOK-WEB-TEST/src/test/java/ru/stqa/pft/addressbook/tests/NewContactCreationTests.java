package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() {

    app.goTo().homePage();
    List<ContactData> before = app.contact().conactList();
    app.contact().initContactCreation();
    ContactData contact = (new ContactData("Jimmy", "Boo", "Po", null, "developer", "Po-dev", null, "indo@test.com", "indo_double@test.com", "indo_double@test.com", "1988"));
    app.contact().fillContactData(contact);
    app.contact().returnToHomePage();
    List<ContactData> after = app.contact().conactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    /*int max = 0;
    for(ContactData g: after){
      if (g.getId() > max){
        max = g.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    /*old version
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    */
    before.add(contact);
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    Comparator<? super ContactData> byId = (Comparator<ContactData>) (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}

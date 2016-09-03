package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class NewContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {

    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();

      while (line != null) {
        json += line;
        line = reader.readLine();
      }

      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }


  @Test(dataProvider = "validContacts")

  public void testNewContactCreation(ContactData contact) {

    app.goTo().homePage();
    Contacts before = app.contact().allConacts();
    //File photo = new File("src/test/resources/123.jpg");
    /*ContactData contact = (new ContactData()
            .withName("Judi").withLastName("Jaster").withCompany("Yahoo").withTitle("QA").withEmail("indo6@test.com").withEmail2("indo_doublex@test.com")
            .withYear("1987").withHomeNumber("6666").withMobileNumber("999").withWorkNumber("777").withPhoto(photo));*/
    app.contact().createContact(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after =  app.contact().allConacts();

    assertThat(after, equalTo(before.withAdded(contact.withId((after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))));


  }

}

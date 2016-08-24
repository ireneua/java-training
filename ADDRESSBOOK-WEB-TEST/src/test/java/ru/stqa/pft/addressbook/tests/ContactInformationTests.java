package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by irener on 8/24/16.
 */
public class ContactInformationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsForContacts() {
    app.goTo().homePage();
    if (app.contact().contactList().size() == 0) {
      app.contact().createContact(new ContactData()
              .withName("Judi").withLastName("Jaster").withCompany("CocaCola").withTitle("Dev").withEmail("indo8@test.com").withEmail2("indo_doublex@test.com")
              .withYear("1937"));
    }
  }

  @Test
  public void testAllContactInfo(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contactInfoFromViewForm.getAllContactData(), equalTo(mergeContactData(contactInfoFromEditForm)));


  }

  private String mergeContactData(ContactData contact) {
    String name = Arrays.asList(contact.getName())
            .stream().filter((s) -> s != null).filter((s) -> !s.equals(""))
            .map(ContactInformationTests::cleanedInfo)
            .collect(Collectors.joining("\n"));

    String lastName = Arrays.asList(contact.getLastname())
            .stream().filter((s) -> s != null).filter((s) -> !s.equals(""))
            .map(ContactInformationTests::cleanedInfo)
            .collect(Collectors.joining("\n"));

    String address = Arrays.asList(contact.getAddress())
            .stream().filter((s) -> s != null).filter((s) -> !s.equals(""))
            .map(ContactInformationTests::cleanedInfo)
            .collect(Collectors.joining("\n"));

    String homeNumber = "H: " + Arrays.asList(contact.getHomeNumber())
            .stream().filter((s) -> s != null).filter((s) -> !s.equals(""))
            .map(ContactInformationTests::cleanedPhone)
            .collect(Collectors.joining("\n"));

    String mobileNumber = "M: " + Arrays.asList(contact.getMobileNumber())
            .stream().filter((s) -> s != null).filter((s) -> !s.equals(""))
            .map(ContactInformationTests::cleanedPhone)
            .collect(Collectors.joining("\n"));

    String workNumber = "W: " + Arrays.asList(contact.getWorkNumber())
            .stream().filter((s) -> s != null).filter((s) -> !s.equals(""))
            .map(ContactInformationTests::cleanedPhone)
            .collect(Collectors.joining("\n"));

    String email = Arrays.asList(contact.getEmail())
            .stream().filter((s) -> s != null).filter((s) -> !s.equals(""))
            .map(ContactInformationTests::cleanedInfo)
            .collect(Collectors.joining("\n"));

    String email2 = Arrays.asList(contact.getEmail2())
            .stream().filter((s) -> s != null).filter((s) -> !s.equals(""))
            .map(ContactInformationTests::cleanedInfo)
            .collect(Collectors.joining("\n"));

    String email3 = Arrays.asList(contact.getEmail3())
            .stream().filter((s) -> s != null).filter((s) -> !s.equals(""))
            .map(ContactInformationTests::cleanedInfo)
            .collect(Collectors.joining("\n"));

    return name + " " + lastName +"\n" + address + "\n\n" + homeNumber + "\n" + mobileNumber + "\n" + workNumber + "\n\n"
            + email + "\n" + email2 + "\n" + email3;
  }

  private static String cleanedInfo(String info) {
    return info.replaceAll("-()","");
  }

  public static String cleanedPhone(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("-()", "");
  }


}

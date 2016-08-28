package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by irener on 8/28/16.
 */
public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {

    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    saveContacts(contacts,file);

  }

  private static void saveContacts(List<ContactData> contacts, File file) throws IOException {

    Writer writer = new FileWriter(file);
    for (ContactData contact: contacts){
      writer.write(String.format("%s;%s;%s;%s\n",
              contact.getName(), contact.getLastname(), contact.getEmail(), contact.getHomeNumber()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i< count; i++){
    contacts.add(new ContactData().withName(String.format("Contact_name %s", i))
            .withLastName(String.format("contact_lastname %s", i))
            .withEmail(String.format("email@email.com %s", i))
            .withHomeNumber(String.format("9349834 %s", i)));
    }
    return contacts;
  }
}

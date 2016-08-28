package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
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

  @Parameter(names = "-c", description = "Contacts count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {

    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try{
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {

    List<ContactData> contacts = generateContacts(count);
    saveContacts(contacts, new File(file));
  }

  private static void saveContacts(List<ContactData> contacts, File file) throws IOException {

    Writer writer = new FileWriter(file);
    for (ContactData contact: contacts){
      writer.write(String.format("%s;%s;%s;%s\n",
              contact.getName(), contact.getLastname(), contact.getEmail(), contact.getHomeNumber()));
    }
    writer.close();
  }

  private void saveContactsAsJson(List<GroupData> contacts, File file) throws IOException {
    Gson gson = new Gson();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
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

package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;

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

  @Parameter(names = "-d", description = "data format")
  public String format;

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

    if (format.equals("csv")) {
      saveContacts(contacts, new File(file));
    } else if (format.equals("json")) {
      saveContactsAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private static void saveContacts(List<ContactData> contacts, File file) throws IOException {

    Writer writer = new FileWriter(file);
    for (ContactData contact: contacts){
      writer.write(String.format("%s;%s;%s;%s\n",
              contact.getName(), contact.getLastname(),
              contact.getEmail(), contact.getHomeNumber()));
    }
    writer.close();
  }


  private void saveContactsAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);

    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
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

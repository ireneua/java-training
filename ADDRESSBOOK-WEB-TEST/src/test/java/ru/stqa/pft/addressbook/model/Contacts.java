package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by irener on 8/21/16.
 */
public class Contacts extends ForwardingSet<ContactData> {

  private Set<ContactData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<>();
  }


  public Contacts withAdded(ContactData contact){
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts withoutAdded(ContactData contact){
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate;
  }

}

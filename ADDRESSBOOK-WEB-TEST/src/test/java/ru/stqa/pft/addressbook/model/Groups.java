package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by irener on 8/20/16.
 */
public class Groups extends ForwardingSet<GroupData>{

  private Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Groups() {
    this.delegate = new HashSet<>();
  }

  public Groups(Collection<GroupData> groups) {
    this.delegate = new HashSet<GroupData>(groups);
  }

  public Groups withAdded(GroupData group){
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups withoutAdded(GroupData group){
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }

  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }
}

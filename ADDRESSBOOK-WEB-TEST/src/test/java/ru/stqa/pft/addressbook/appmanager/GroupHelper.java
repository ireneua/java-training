package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irener on 7/28/16.
 */
public class GroupHelper extends HelperBase {


  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
    click(By.xpath("//div[@id='content']/form"));
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    groupCache = null;
    returnToGroupPage();
  }

  private void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCache = null;
    returnToGroupPage();

  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCache = null;
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData().withId(id).withHeader("header_group").withFooter("group_footer").withName(name);
      groups.add(group);
    }
    return groups;

  }

  private Groups groupCache = null;


  public Groups all() {

    if (groupCache != null) {
      return new Groups(groupCache);
    }

    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);

  }


}

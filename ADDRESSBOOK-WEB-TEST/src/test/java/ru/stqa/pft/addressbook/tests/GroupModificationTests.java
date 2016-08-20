package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by irener on 7/29/16.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("Petrov"));
    }
  }

  @Test(enabled = true)

  public void testGroupModification() {

    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId())
            .withName("modification1").withFooter("footer_modi").withHeader("header_modi");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(before.size(), after.size());

    before.remove(modifiedGroup);
    before.add(group);
    assertEquals(before, after);
    assertThat(after, equalTo(before));
    assertThat(after, equalTo(before.withoutAdded(modifiedGroup).withoutAdded(group)));

  }

}

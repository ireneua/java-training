package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test(enabled = true)

  public void testGroupCreation() {

    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("Pushkin");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(before.size() + 1, after.size());

    group.withId((after.stream().mapToInt((g) -> g.getId()).max().getAsInt()));
    before.add(group);

    Assert.assertEquals(before, after);
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before));
  }

}

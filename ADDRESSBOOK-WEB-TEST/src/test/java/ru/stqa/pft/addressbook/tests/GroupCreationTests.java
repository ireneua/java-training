package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

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


public class GroupCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {

    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
      String json = "";
      String line = reader.readLine();

      while (line != null) {
        json += line;
        line = reader.readLine();
      }

      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
      }.getType());
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validGroups")

  public void testGroupCreation(GroupData group) {

    Groups before = app.db().groups();
    app.goTo().groupPage();
    app.group().create(group);
    assertThat(app.group().getGroupCount(), equalTo(before.size() + 1));
    Groups after = app.db().groups();

    assertThat(after, equalTo(before.withoutAdded(group)));
    /*assertThat(after,
            equalTo(before.withAdded(group.withId((after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))));*/

  }

}

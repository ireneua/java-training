package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletionTests() {

    goToGroupPage();
    selectGroup();
    deleteGroup();
    returnToGroupPage();
  }

  private void deleteGroup() {
    wd.findElement(By.name("delete")).click();
  }

  private void selectGroup() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      wd.findElement(By.name("selected[]")).click();
    }
  }


}

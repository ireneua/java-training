package ru.stqa.pft.addressbook;

<<<<<<< HEAD
import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase{

  @Test
  public void testGroupDeletion() {

    goToGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

=======
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

>>>>>>> origin/master

}

package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
<<<<<<< HEAD
    public void testGroupCreation() {
=======
    public void testGroupCreationTests() {
>>>>>>> origin/master

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("myTestGroup", "header", "footer"));
        submitGroupCreation();
        returnToGroupPage();
    }

}

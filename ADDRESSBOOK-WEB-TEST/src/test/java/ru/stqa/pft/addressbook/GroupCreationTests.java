package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreationTests() {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("myTestGroup", "header", "footer"));
        submitGroupCreation();
        returnToGroupPage();
    }

}

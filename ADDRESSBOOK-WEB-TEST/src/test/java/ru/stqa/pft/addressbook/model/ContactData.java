package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String middlename;
  private final String lastaname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String home;
  private final String email;
  private final String email2;
  private final String email22;
  private final String year;

  public ContactData(String name, String middlename, String lastaname, String nickname, String title, String company, String home, String email, String email2, String email22, String year) {
    this.name = name;
    this.middlename = middlename;
    this.lastaname = lastaname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.home = home;
    this.email = email;
    this.email2 = email2;
    this.email22 = email22;
    this.year = year;
  }

  public String getName() {
    return name;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastaname() {
    return lastaname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getHome() {
    return home;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail22() {
    return email22;
  }

  public String getYear() {
    return year;
  }
}

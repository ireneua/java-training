package ru.stqa.pft.addressbook.model;

public class ContactData {
  private  int id;
  private  String name;
  private  String middlename;
  private  String lastname;
  private  String nickname;
  private  String title;

  public void withTitle(String title) {
    this.title = title;
  }

  public void withName(String name) {
    this.name = name;
  }

  public void withMiddleName(String middlename) {
    this.middlename = middlename;
  }

  public void withLastName(String lastname) {
    this.lastname = lastname;
  }

  public void withNickname(String nickname) {
    this.nickname = nickname;
  }

  public void withCompany(String company) {
    this.company = company;
  }

  public void withHome(String home) {
    this.home = home;
  }

  public void withEmail(String email) {
    this.email = email;
  }

  public void withEmail2(String email2) {
    this.email2 = email2;
  }

  public void withEmail22(String email22) {
    this.email22 = email22;
  }

  public void withYear(String year) {
    this.year = year;
  }

  private  String company;
  private  String home;
  private  String email;
  private  String email2;
  private  String email22;
  private  String year;


  public ContactData(int id, String name, String middlename, String lastname, String nickname, String title, String company, String home, String email, String email2, String email22, String year) {
    this.id = id;
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;

    this.company = company;
    this.home = home;
    this.email = email;
    this.email2 = email2;
    this.email22 = email22;
    this.year = year;
  }


  public ContactData(String name, String middlename, String lastname, String nickname, String title, String company, String home, String email, String email2, String email22, String year) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
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

  public String getLastname() {
    return lastname;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public void setId(int id) {
    this.id = id;
  }
}

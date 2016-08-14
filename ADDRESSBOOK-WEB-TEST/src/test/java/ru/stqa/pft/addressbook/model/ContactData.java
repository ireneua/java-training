package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String id;
  private final String name;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String home;
  private final String email;
  private final String email2;
  private final String email22;
  private final String year;



  public ContactData(String id, String name, String middlename, String lastname, String nickname, String title, String company, String home, String email, String email2, String email22, String year) {
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
    this.id = null;
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

  public String getId() {
    return id;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

}

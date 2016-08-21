package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String middlename;
  private String lastname;
  private String title;
  private String company;
  private String address;
  private String email;
  private String email2;
  private String year;
  private String homeNumber;
  private String MobileNumber;
  private String WorkNumber;
  private String allPhones;


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withMiddleName(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastName(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withYear(String year) {
    this.year = year;
    return this;
  }

  public ContactData withHomeNumber(String homeNumber){
    this.homeNumber = homeNumber;
    return this;
  }

  public ContactData withWorkNumber(String workNumber){
    this.homeNumber = workNumber;
    return this;
  }

  public ContactData withMobileNumber(String mobileNumber){
    this.homeNumber = mobileNumber;
    return this;
  }

  public ContactData withAllPhones(String allPhones){
    this.allPhones = allPhones;
    return this;
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

  public String getTitle() {
    return title;
  }

  public String getHomeNumber() {
    return homeNumber;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public void setHomeNumber(String homeNumber) {
    this.homeNumber = homeNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    MobileNumber = mobileNumber;
  }

  public void setWorkNumber(String workNumber) {
    WorkNumber = workNumber;
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

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getMobileNumber() {
    return MobileNumber;
  }

  public String getYear() {
    return year;
  }

  public String getAllPhones(){ return allPhones;}

  public String getWorkNumber() {
    return WorkNumber;
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

  public void setId(int id) {
    this.id = id;
  }
}



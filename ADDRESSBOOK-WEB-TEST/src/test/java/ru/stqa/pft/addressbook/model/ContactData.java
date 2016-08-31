package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;

  @Expose
  private String name;
  private String middlename;

  @Expose
  private String lastname;
  private String title;
  private String company;
  private String address;
  @Expose
  private String email;
  private String email2;
  private String email3;
  private String year;
  @Expose
  private String homeNumber;
  private String mobileNumber;
  private String workNumber;
  private String allPhones;
  private String allEmails;
  private String allContactData;
  private File photo;


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

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
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
    this.workNumber = workNumber;
    return this;
  }

  public ContactData withMobileNumber(String mobileNumber){
    this.mobileNumber = mobileNumber;
    return this;
  }

  public ContactData withAllPhones(String allPhones){
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails){
     this.allEmails = allEmails;
    return this;
  }

  public ContactData withAllContactInfo(String allContactData) {
    this.allContactData = allContactData;
    return  this;
  }


  public ContactData withPhoto(File photo) {
    this.photo = photo;
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

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getYear() {
    return year;
  }

  public File getPhoto() {
    return photo;
  }

  public String getAllPhones(){
    return allPhones;}

  public String getWorkNumber() {
    return workNumber;
  }

  public String getAllEmails(){
    return allEmails;}

  public String getAllContactData(){
    return allContactData;
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

  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }


}



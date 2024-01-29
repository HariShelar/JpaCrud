package com.jpa.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="UsersInfo")
public class Usernew {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  
  @Column(name="First_name")
  private String FirstName;
  
  @Column(name="Last_name")
  private String LastName;
  
  @Column(name="Email")
  private String Email;
  
  public Usernew() { } 
  
  public Usernew(String FirstName, String LastName, String Email) {
	  super();
	  this.FirstName=FirstName;
	  this.LastName=LastName;
	  this.Email=Email;
  }
  
  public long getId() {
	  return id;
  }
  public void setId(long id) {
	  this.id=id;
  }
  public String getFirstName() {
	  return FirstName;
  }
  public void setFirstName(String FirstName) {
	  this.FirstName=FirstName;
  }
  public String getLastName() {
	  return LastName;
  }
  public void setLastName(String LastName) {
	  this.LastName=LastName;
  }
  public String getEmail() {
	  return Email;
  }
  public void setEmail(String Email) {
	  this.Email=Email;
  }
}

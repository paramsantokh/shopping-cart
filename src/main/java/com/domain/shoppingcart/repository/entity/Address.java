package com.domain.shoppingcart.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address{
  
  @Id
  @Column (name = "ADDR_ID")
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private String id;
  
  private String addressLine;
  
  private String city;
  
  private String state;
  
  private long pinCode;
  
  public Address() {
  }
  
  public Address(String addressLine, String city, String state, long pinCode) {
    this.addressLine = addressLine;
    this.city = city;
    this.state = state;
    this.pinCode = pinCode;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getAddressLine() {
    return addressLine;
  }
  
  public void setAddressLine(String addressLine) {
    this.addressLine = addressLine;
  }
  
  public String getCity() {
    return city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getState() {
    return state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public long getPinCode() {
    return pinCode;
  }
  
  public void setPinCode(long pinCode) {
    this.pinCode = pinCode;
  }
  
  @Override
  public String toString() {
    return "Address{" +
           "id='" + id + '\'' +
           ", addressLine='" + addressLine + '\'' +
           ", city='" + city + '\'' +
           ", state='" + state + '\'' +
           ", pinCode=" + pinCode +
           '}';
  }
}

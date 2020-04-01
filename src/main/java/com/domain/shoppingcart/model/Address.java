package com.domain.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
  
  @JsonProperty
  private String id;
  @JsonProperty
  private String type;
  @JsonProperty
  private String addressLine;
  @JsonProperty
  private String city;
  @JsonProperty
  private String state;
  @JsonProperty
  private long pinCode;
  
  public Address() {
  }
  
  public Address(String id, String type, String addressLine, String city, String state, long pinCode) {
    this.id = id;
    this.type = type;
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
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
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
}

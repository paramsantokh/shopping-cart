package com.domain.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
  @JsonProperty
  private String customerId;
  @JsonProperty
  private String name;
  
  @JsonProperty
  private Address address;
  
  public Customer() {
  }
  
  public Customer(String customerId, String name, Address address) {
    this.customerId = customerId;
    this.name = name;
    this.address = address;
  }
  
  public String getCustomerId() {
    return customerId;
  }
  
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Address getAddress() {
    return address;
  }
  
  public void setAddress(Address address) {
    this.address = address;
  }
}

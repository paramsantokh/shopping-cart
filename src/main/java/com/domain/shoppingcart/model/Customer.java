package com.domain.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Customer {
  @JsonProperty
  private String customerId;
  @JsonProperty
  private String name;
  
  @JsonProperty
  private List<Address> addresses;
  
  public Customer() {
  }
  
  public Customer(String customerId, String name, List<Address> addresses) {
    this.customerId = customerId;
    this.name = name;
    this.addresses = addresses;
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
  
  public List<Address> getAddresses() {
    return addresses;
  }
  
  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }
}

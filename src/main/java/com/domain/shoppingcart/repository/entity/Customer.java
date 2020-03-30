package com.domain.shoppingcart.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@JsonIgnoreProperties (ignoreUnknown = false)
@Proxy (lazy = false)
public class Customer {
  
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private String customerId;
  
  private String name;
  
  @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name="ADDR_ID")
  private Address address;
  
  public Customer() {
  }
  
  public Customer(String name, Address address) {
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

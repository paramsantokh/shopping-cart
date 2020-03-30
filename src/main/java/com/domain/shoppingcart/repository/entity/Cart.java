package com.domain.shoppingcart.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
  @Id
  @Column (name = "CART_ID")
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long id;
  
  private String customerId;
  
  private long itemId;
  
  private int quantity;
  
  private double amount;
  
  public Cart(){
  
  }
  
  public Cart(String customerId, long itemId, int quantity, double amount) {
    this.customerId = customerId;
    this.itemId = itemId;
    this.quantity = quantity;
    this.amount = amount;
  }
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getCustomerId() {
    return customerId;
  }
  
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }
  
  public long getItemId() {
    return itemId;
  }
  
  public void setItemId(long itemId) {
    this.itemId = itemId;
  }
  
  public int getQuantity() {
    return quantity;
  }
  
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
  public double getAmount() {
    return amount;
  }
  
  public void setAmount(double amount) {
    this.amount = amount;
  }
}

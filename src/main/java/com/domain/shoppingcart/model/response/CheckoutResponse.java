package com.domain.shoppingcart.model.response;

import com.domain.shoppingcart.model.Customer;

import java.util.List;

public class CheckoutResponse {
  
  private Customer customer;
  private List<Item> items;
  
  private double totalAmount;
  
  public CheckoutResponse() {
  }
  
  public CheckoutResponse(Customer customer, List<Item> items, double totalAmount) {
    this.customer = customer;
    this.items = items;
    this.totalAmount = totalAmount;
  }
  
  public Customer getCustomer() {
    return customer;
  }
  
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  
  public List<Item> getItems() {
    return items;
  }
  
  public void setItems(List<Item> items) {
    this.items = items;
  }
  
  public double getTotalAmount() {
    return totalAmount;
  }
  
  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }
}

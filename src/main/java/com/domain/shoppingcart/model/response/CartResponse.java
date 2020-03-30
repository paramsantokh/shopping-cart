package com.domain.shoppingcart.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CartResponse {
  
  @JsonProperty
  private String customerId;
  
  @JsonProperty
  private List<Item> item;
  
  public CartResponse() {
  }
  
  public CartResponse(String customerId, List<Item> item) {
    this.customerId = customerId;
    this.item = item;
  }
  
  public String getCustomerId() {
    return customerId;
  }
  
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }
  
  public List<Item> getItem() {
    return item;
  }
  
  public void setItem(List<Item> item) {
    this.item = item;
  }
}

package com.domain.shoppingcart.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartRequest {
  @JsonProperty
  private String customerId;
  
  @JsonProperty
  private CartItem cartItem;
  
  public CartRequest() {
  }
  
  public CartRequest(String customerId, CartItem cartItem) {
    this.customerId = customerId;
    this.cartItem = cartItem;
  }
  
  public String getCustomerId() {
    return customerId;
  }
  
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }
  
  public CartItem getCartItem() {
    return cartItem;
  }
  
  public void setCartItem(CartItem cartItem) {
    this.cartItem = cartItem;
  }
}

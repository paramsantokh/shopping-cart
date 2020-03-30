package com.domain.shoppingcart.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartItem {
  
  @JsonProperty
  private long itemId;
  @JsonProperty
  private String itemSku;
  @JsonProperty
  private int quantity;
  
  public CartItem() {
  }
  
  public CartItem(long itemId, String itemSku, int quantity) {
    this.itemId = itemId;
    this.itemSku = itemSku;
    this.quantity = quantity;
  }
  
  public long getItemId() {
    return itemId;
  }
  
  public void setItemId(long itemId) {
    this.itemId = itemId;
  }
  
  public String getItemSku() {
    return itemSku;
  }
  
  public void setItemSku(String itemSku) {
    this.itemSku = itemSku;
  }
  
  public int getQuantity() {
    return quantity;
  }
  
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}

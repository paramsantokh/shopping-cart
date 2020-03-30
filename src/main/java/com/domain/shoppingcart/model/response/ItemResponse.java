package com.domain.shoppingcart.model.response;

import java.util.ArrayList;
import java.util.List;

public class ItemResponse {
  
  private List<Item> items;
  
  public ItemResponse() {
  }
  
  public ItemResponse(Item item) {
    items = new ArrayList<>();
    items.add(item);
  }
  
  public List<Item> getItems() {
    return items;
  }
  
  public void setItems(List<Item> items) {
    this.items = items;
  }
}

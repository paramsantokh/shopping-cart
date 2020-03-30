package com.domain.shoppingcart.model.request;

import java.util.List;

public class ItemRequest {
  private List<CatalogItem> catalogItems;
  
  public List<CatalogItem> getCatalogItems() {
    return catalogItems;
  }
  
  public void setCatalogItems(List<CatalogItem> catalogItems) {
    this.catalogItems = catalogItems;
  }
}

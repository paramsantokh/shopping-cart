package com.domain.shoppingcart.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatalogItem {
  @JsonProperty("id")
  private long id;
  @JsonProperty("sku")
  private String sku;
  @JsonProperty("category")
  private String category;
  @JsonProperty("price")
  private double price;
  @JsonProperty("title")
  private String title;
  @JsonProperty("author")
  private String author;
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getSku() {
    return sku;
  }
  
  public void setSku(String sku) {
    this.sku = sku;
  }
  
  public String getCategory() {
    return category;
  }
  
  public void setCategory(String category) {
    this.category = category;
  }
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getAuthor() {
    return author;
  }
  
  public void setAuthor(String author) {
    this.author = author;
  }
}

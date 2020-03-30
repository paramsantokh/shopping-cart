package com.domain.shoppingcart.model.response;

import com.domain.shoppingcart.repository.entity.ItemEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
  
  @JsonProperty
  private long id;
  @JsonProperty("sku")
  private String sku;
  @JsonProperty
  private String category;
  @JsonProperty
  private double price;
  @JsonProperty
  private int quantity;
  
  @JsonProperty
  private Book book;
  
  public Item() {
  }
  
  public Item(long id, String sku, String category, double price, int quantity, Book book) {
    this.id = id;
    this.sku = sku;
    this.category = category;
    this.price = price;
    this.quantity = quantity;
    this.book = book;
  }
  
  public Item(ItemEntity itemEntity) {
    this.id = itemEntity.getId();
    this.category = itemEntity.getCategory();
    this.price = itemEntity.getPrice();
    this.quantity = itemEntity.getQuantity();
    this.book = new Book(itemEntity.getBookDetails());
  }
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
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
  
  public String getSku() {
    return sku;
  }
  
  public void setSku(String sku) {
    this.sku = sku;
  }
  
  public int getQuantity() {
    return quantity;
  }
  
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
  public Book getBook() {
    return book;
  }
  
  public void setBook(Book book) {
    this.book = book;
  }
}

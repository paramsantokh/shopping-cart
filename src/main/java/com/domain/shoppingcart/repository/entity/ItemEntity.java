package com.domain.shoppingcart.repository.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ItemEntity {
  
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long id;
  private String sku;
  private String category;
  private double price;
  private int quantity;
  
  @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn (name = "id")
  private BookDetails bookDetails;
  
  public ItemEntity() {
  }
  
  public ItemEntity(String sku, String category, double price, int quantity, BookDetails bookDetails) {
    this.sku = sku;
    this.category = category;
    this.price = price;
    this.quantity = quantity;
    this.bookDetails = bookDetails;
  }
  
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
  
  public int getQuantity() {
    return quantity;
  }
  
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
  public BookDetails getBookDetails() {
    return bookDetails;
  }
  
  public void setBookDetails(BookDetails bookDetails) {
    this.bookDetails = bookDetails;
  }
}

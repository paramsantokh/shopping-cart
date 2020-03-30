package com.domain.shoppingcart.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String sku;
  private String title;
  private String author;
  
  public BookDetails() {
  }
  
  public BookDetails(String sku, String title, String author) {
    this.sku = sku;
    this.title = title;
    this.author = author;
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

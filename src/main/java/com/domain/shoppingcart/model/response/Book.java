package com.domain.shoppingcart.model.response;

import com.domain.shoppingcart.repository.entity.BookDetails;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Book {
  @JsonProperty
  private long id;
  @JsonProperty
  private String title;
  @JsonProperty
  private String author;
  
  public Book() {
  }
  
  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }
  
  public Book(BookDetails book) {
    this.id = book.getId();
    this.title = book.getTitle();
    this.author = book.getAuthor();
  }
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
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

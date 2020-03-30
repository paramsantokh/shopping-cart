package com.domain.shoppingcart.controller;

import com.domain.shoppingcart.model.Customer;
import com.domain.shoppingcart.model.request.ItemRequest;
import com.domain.shoppingcart.model.response.Item;
import com.domain.shoppingcart.model.response.ItemResponse;
import com.domain.shoppingcart.repository.entity.Discount;
import com.domain.shoppingcart.repository.entity.Tax;
import com.domain.shoppingcart.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/shopping-cart/catalog")
public class CatalogController {
  
  @Autowired
  private CatalogService catalogService;
  
  @PostMapping ("/item")
  public ResponseEntity<ItemResponse> addItem(HttpServletResponse response, @RequestBody ItemRequest items) {
    if (items == null || items.getCatalogItems() == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
    
    ItemResponse itemResponse = catalogService.addItems(items);
    
    return new ResponseEntity<>(itemResponse, HttpStatus.OK);
  }
  
  @PutMapping ("/item")
  public ResponseEntity<ItemResponse> updateItem(HttpServletResponse response, @RequestBody ItemRequest items) {
    if (items == null || items.getCatalogItems() == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
    
    ItemResponse itemResponse = catalogService.updateItems(items);
    
    return new ResponseEntity<>(itemResponse, HttpStatus.OK);
  }
  
  @DeleteMapping ("/item/{id}")
  public ResponseEntity<ItemResponse> deleteItem(@PathVariable (name = "id") Long id) {
    
    ItemResponse itemResponse = catalogService.deleteItem(id);
    return new ResponseEntity<>(itemResponse, HttpStatus.OK);
  }
  
  @GetMapping ("/item/{id}")
  public ResponseEntity<Item> getItem(@PathVariable (name = "id") Long itemId) {
    Item item = catalogService.getItemById(itemId);
    
    return new ResponseEntity<>(item, HttpStatus.OK);
  }
  
  @GetMapping ("/items")
  public ResponseEntity<ItemResponse> getItems() {
    ItemResponse itemResponse = catalogService.getItems();
    
    return new ResponseEntity<>(itemResponse, HttpStatus.OK);
  }
  
  @PostMapping ("/customer")
  public ResponseEntity<List<com.domain.shoppingcart.repository.entity.Customer>> addCustomer(HttpServletResponse response, @RequestBody Customer customer) {
    if (customer == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    List<com.domain.shoppingcart.repository.entity.Customer> customer1 = catalogService.addCustomer(customer);
    return new ResponseEntity<>(customer1, HttpStatus.OK);
  }
  
  @DeleteMapping ("/customer/{customerId}")
  public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable String customerId) {
    return new ResponseEntity<>(catalogService.deleteCustomer(customerId), HttpStatus.OK);
  }
  
  @PutMapping ("/customer")
  public ResponseEntity<List<com.domain.shoppingcart.repository.entity.Customer>> updateCustomer(HttpServletResponse response, @RequestBody Customer customer) {
    if (customer == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    List<com.domain.shoppingcart.repository.entity.Customer> customer1 = catalogService.addCustomer(customer);
    return new ResponseEntity<>(customer1, HttpStatus.OK);
  }
  
  @GetMapping ("/customer/{customerId}")
  ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
    return new ResponseEntity<>(catalogService.getCustomer(customerId), HttpStatus.OK);
  }
  
  @GetMapping ("/customers")
  ResponseEntity<List<Customer>> getCustomers() {
    return new ResponseEntity<>(catalogService.getCustomers(), HttpStatus.OK);
  }
  
  @PostMapping ("/discount")
  public ResponseEntity<List<Discount>> addDiscount(HttpServletResponse response, @RequestBody Discount discount) {
    
    List<Discount> discounts = new ArrayList<>(); //call service to add discount and return updated discount list
    return new ResponseEntity<>(discounts, HttpStatus.OK);
  }
  
  @GetMapping ("/discounts")
  public List<Discount> getDiscounts() {
    //call service to get all discounts
    return new ArrayList<>();
  }
  
  @PostMapping ("/tax")
  public ResponseEntity<List<Tax>> addTax(HttpServletResponse response, @RequestBody Tax tax) {
    
    List<Tax> taxes = new ArrayList<>(); //call service to add tax and return updated tax list
    return new ResponseEntity<>(taxes, HttpStatus.OK);
  }
  
  @GetMapping ("/taxes")
  public List<Tax> getTaxes() {
    //call service to get all taxes
    return new ArrayList<>();
  }
}

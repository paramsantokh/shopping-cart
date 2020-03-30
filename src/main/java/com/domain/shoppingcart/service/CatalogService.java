package com.domain.shoppingcart.service;


import com.domain.shoppingcart.model.Customer;
import com.domain.shoppingcart.model.request.ItemRequest;
import com.domain.shoppingcart.model.response.Item;
import com.domain.shoppingcart.model.response.ItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatalogService {
  
  public ItemResponse addItems(ItemRequest items);
  
  public ItemResponse updateItems(ItemRequest items);
  
  public ItemResponse getItems();
  
  public Item getItemById(long id);
  
  public ItemResponse deleteItem(long id);
  
  public List<com.domain.shoppingcart.repository.entity.Customer> addCustomer(Customer customer);
  
  public List<Customer> deleteCustomer(String id);
  
  public List<Customer> getCustomers();
  
  public Customer getCustomer(String id);
}

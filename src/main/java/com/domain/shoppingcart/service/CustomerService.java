package com.domain.shoppingcart.service;

import com.domain.shoppingcart.model.Customer;

public interface CustomerService {

  public Customer addCustomer(Customer customer);
  
  public Customer deleteCustomer(String id);
  
  public Customer updateCustomer(Customer customer);
}

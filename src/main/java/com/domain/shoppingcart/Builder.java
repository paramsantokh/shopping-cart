package com.domain.shoppingcart;

import com.domain.shoppingcart.model.Address;
import com.domain.shoppingcart.model.Customer;

public class Builder {
  
  Customer reqCustomer;
  com.domain.shoppingcart.repository.entity.Customer entityCutsomer;
  
  public Builder(Customer reqCustomer) {
    entityCutsomer = new com.domain.shoppingcart.repository.entity.Customer();
    entityCutsomer.setCustomerId(reqCustomer.getCustomerId());
    entityCutsomer.setName(reqCustomer.getName());
    
    entityCutsomer.setAddress(toAddress(reqCustomer.getAddress()));
  }
  
  public Builder(com.domain.shoppingcart.repository.entity.Customer entityCustomer) {
    reqCustomer = new Customer();
    reqCustomer.setCustomerId(entityCustomer.getCustomerId());
    reqCustomer.setName(entityCustomer.getName());
    
    reqCustomer.setAddress(toAddress(entityCustomer.getAddress()));
  }
  
  private com.domain.shoppingcart.repository.entity.Address toAddress(Address address) {
    com.domain.shoppingcart.repository.entity.Address address1
        = new com.domain.shoppingcart.repository.entity.Address(address.getAddressLine(), address.getCity(), address.getState(), address.getPinCode());
    return address1;
  }
  
  private Address toAddress(com.domain.shoppingcart.repository.entity.Address address) {
    Address address1
        = new Address(address.getId(), address.getAddressLine(), address.getCity(), address.getState(), address.getPinCode());
    return address1;
  }
  
  public com.domain.shoppingcart.repository.entity.Customer getEntityCutsomer() {
    return entityCutsomer;
  }
  
  public void setEntityCutsomer(com.domain.shoppingcart.repository.entity.Customer entityCutsomer) {
    this.entityCutsomer = entityCutsomer;
  }
  
  public Customer getReqCustomer() {
    return reqCustomer;
  }
  
  public void setReqCustomer(Customer reqCustomer) {
    this.reqCustomer = reqCustomer;
  }
}

package com.domain.shoppingcart;

import com.domain.shoppingcart.model.Address;
import com.domain.shoppingcart.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class Builder {
  
  Customer reqCustomer;
  com.domain.shoppingcart.repository.entity.Customer entityCutsomer;
  
  public Builder(Customer reqCustomer) {
    entityCutsomer = new com.domain.shoppingcart.repository.entity.Customer();
    entityCutsomer.setCustomerId(reqCustomer.getCustomerId());
    entityCutsomer.setName(reqCustomer.getName());
    
    entityCutsomer.setAddress(toEntityAddress(reqCustomer.getAddresses()));
  }
  
  public Builder(com.domain.shoppingcart.repository.entity.Customer entityCustomer) {
    reqCustomer = new Customer();
    reqCustomer.setCustomerId(entityCustomer.getCustomerId());
    reqCustomer.setName(entityCustomer.getName());
    
    reqCustomer.setAddresses(toModelAddress(entityCustomer.getAddress()));
  }
  
  public List<com.domain.shoppingcart.repository.entity.Address> toEntityAddress(List<Address> addresses) {
    List<com.domain.shoppingcart.repository.entity.Address> addressList = new ArrayList<>();
    addresses.forEach(address -> {
      addressList.add(new com.domain.shoppingcart.repository.entity.Address(address.getType(), address.getAddressLine(), address.getCity(), address.getState(), address.getPinCode()));
    });
    
    return addressList;
  }
  
  private List<Address> toModelAddress(List<com.domain.shoppingcart.repository.entity.Address> addresses) {
    List<Address> addressList = new ArrayList<>();
    addresses.forEach(address -> {
      addressList.add(new Address(address.getId(), address.getAddressType(), address.getAddressLine(), address.getCity(), address.getState(), address.getPinCode()));
    });
    
    return addressList;
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

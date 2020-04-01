package com.domain.shoppingcart.service.impl;

import com.domain.shoppingcart.ItemType;
import com.domain.shoppingcart.model.Customer;
import com.domain.shoppingcart.model.request.ItemRequest;
import com.domain.shoppingcart.model.response.ItemResponse;
import com.domain.shoppingcart.repository.entity.BookDetails;
import com.domain.shoppingcart.repository.entity.ItemEntity;
import com.domain.shoppingcart.repository.repo.CustomerRepository;
import com.domain.shoppingcart.repository.repo.ItemRepository;
import com.domain.shoppingcart.Builder;
import com.domain.shoppingcart.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {
  
  @Autowired
  private ItemRepository itemRepository;
  
  @Autowired
  CustomerRepository customerRepository;
  
  @Override
  public ItemResponse addItems(ItemRequest items) {
    if (items == null || items.getCatalogItems() == null) {
      return new ItemResponse();
    }
    
    List<ItemEntity> itemEntityList = new ArrayList<>();
    
    items.getCatalogItems().forEach(item -> {
      ItemEntity itm = new ItemEntity();
      itm.setCategory(item.getCategory());
      itm.setPrice(item.getPrice());
      itm.setSku(item.getSku());
      if (ItemType.BOOK.toString().equalsIgnoreCase(item.getCategory())) {
        BookDetails book = new BookDetails(item.getSku(), item.getTitle(), item.getAuthor());
        itm.setBookDetails(book);
      }
      itemEntityList.add(itm);
    });
    
    //persist in DB
    itemRepository.saveAll(itemEntityList);
    
    //Return updated items from DB
    return toResponse(itemRepository.findAll());
  }
  
  @Override
  public ItemResponse updateItems(ItemRequest items) {
    if (items == null || items.getCatalogItems() == null) {
      return null;
    }
    
    List<ItemEntity> itemEntityList = new ArrayList<>();
    items.getCatalogItems().forEach(it -> {
      Optional<ItemEntity> optionalItem = itemRepository.findById(it.getId());
      if (optionalItem.isPresent()) {
        ItemEntity itemEntity = optionalItem.get();
        
        itemEntity.setCategory(it.getCategory());
        itemEntity.setPrice(it.getPrice());
        itemEntity.setSku(it.getSku());
        BookDetails bookDetails = itemEntity.getBookDetails();
        bookDetails.setTitle(it.getTitle());
        bookDetails.setAuthor(it.getAuthor());
        
        itemEntityList.add(itemEntity);
        
        //update
        itemRepository.saveAndFlush(itemEntity);
      }
    });
    
    return toResponse(itemEntityList);
  }
  
  @Override
  public ItemResponse getItems() {
    return toResponse(itemRepository.findAll());
  }
  
  @Override
  public com.domain.shoppingcart.model.response.Item getItemById(long id) {
    return toResponse(itemRepository.findById(id).get());
  }
  
  @Override
  public com.domain.shoppingcart.model.response.ItemResponse deleteItem(long id) {
    itemRepository.deleteById(id);
    return toResponse(itemRepository.findAll());
  }
  
  public com.domain.shoppingcart.model.response.ItemResponse toResponse(List<ItemEntity> itemEntities) {
    if (itemEntities == null || itemEntities.isEmpty()) {
      return null;
    }
    
    List<com.domain.shoppingcart.model.response.Item> itemList = new ArrayList<>();
    itemEntities.forEach(entityItem -> {
      com.domain.shoppingcart.model.response.Item item = new com.domain.shoppingcart.model.response.Item(entityItem);
      itemList.add(item);
    });
    
    ItemResponse itemResponse = new ItemResponse();
    itemResponse.setItems(itemList);
    
    return itemResponse;
  }
  
  public com.domain.shoppingcart.model.response.Item toResponse(ItemEntity entityItem) {
    if (entityItem == null) {
      return null;
    }
    com.domain.shoppingcart.model.response.Item item = new com.domain.shoppingcart.model.response.Item(entityItem);
    
    return item;
  }
  
  @Override
  public List<com.domain.shoppingcart.repository.entity.Customer> addCustomer(Customer customer) {
    //request object to entity object
    Builder builder = new Builder(customer);
    if (customer.getCustomerId() != null && customerRepository.findById(customer.getCustomerId()).isPresent()) {
      //entity object to request object
      customerRepository.saveAndFlush(builder.getEntityCutsomer());
    } else {
      //entity object to request object
      customerRepository.save(builder.getEntityCutsomer());
    }
    
    return customerRepository.findAll();
  }
  
  @Override
  public List<Customer> deleteCustomer(String id) {
    customerRepository.deleteById(id);
    
    return getCustomers();
  }
  
  @Override
  public List<Customer> getCustomers() {
    List<com.domain.shoppingcart.repository.entity.Customer> customers = customerRepository.findAll();
    List<Customer> customerList = new ArrayList<>();
    customers.forEach(customer -> {
      Builder builder = new Builder(customer);
      customerList.add(builder.getReqCustomer());
    });
    
    return customerList;
  }
  
  @Override
  public Customer getCustomer(String id) {
    Optional<com.domain.shoppingcart.repository.entity.Customer> customer = customerRepository.findById(id);
    if (customer.isPresent()) {
      return new Builder(customer.get()).getReqCustomer();
    }
    
    return new Customer();
  }
  
}



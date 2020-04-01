package com.domain.shoppingcart.service.impl;

import com.domain.shoppingcart.model.Address;
import com.domain.shoppingcart.model.Customer;
import com.domain.shoppingcart.model.request.CartItem;
import com.domain.shoppingcart.model.request.CartRequest;
import com.domain.shoppingcart.model.response.CartResponse;
import com.domain.shoppingcart.model.response.CheckoutResponse;
import com.domain.shoppingcart.model.response.Item;
import com.domain.shoppingcart.repository.entity.Cart;
import com.domain.shoppingcart.repository.repo.CartRepository;
import com.domain.shoppingcart.service.CartService;
import com.domain.shoppingcart.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
  
  @Autowired
  CartRepository cartRepository;
  
  @Autowired
  CatalogService catalogService;
  
  @Override
  public CartResponse addToCart(CartRequest cartRequest) {
    String customerId = cartRequest.getCustomerId();
    CartItem cartItem = cartRequest.getCartItem();
    long itemId = cartItem.getItemId();
    
    //check if the item requested already in cart
    Cart cart = getItemInCart(customerId, itemId);
    Item catalogItem = catalogService.getItemById(itemId);
    if (cart != null) {
      //item already in cart:: update quantity and total amount;
      cart.setQuantity(cart.getQuantity() + cartItem.getQuantity());
      cart.setAmount(catalogItem.getPrice() * cart.getQuantity());
      //persist cart with updated quantity
      cartRepository.saveAndFlush(cart);
    } else {
      //new item: add to cart
      cart = new Cart(customerId, itemId, cartItem.getQuantity(), catalogItem.getPrice() * cartItem.getQuantity());
      //persist cart
      cartRepository.save(cart);
    }
    
    CartResponse cartResponse = getCartItems(customerId);
    
    return cartResponse;
  }
  
  public CartResponse deleteCartItem(CartRequest cartRequest) {
    String customerId = cartRequest.getCustomerId();
    CartItem cartItem = cartRequest.getCartItem();
    long itemId = cartItem.getItemId();
    int reqQuantity = cartItem.getQuantity();
    //check if item in cart: update the quantity
    Cart cart = getItemInCart(customerId, itemId);
    Item catalogItem = catalogService.getItemById(itemId);
    if (cart != null) {
      int cartQuantity = cart.getQuantity();
      if (cartQuantity > 0 && cartQuantity > reqQuantity && cartQuantity - reqQuantity != 0) {
        cart.setQuantity(cartQuantity - reqQuantity);
        cart.setAmount(cart.getQuantity() * catalogItem.getPrice());
        cartRepository.saveAndFlush(cart);
      } else {
        cartRepository.deleteItemByCustomerIdAndItemId(customerId, itemId);
      }
    }
    
    return getCartItems(customerId);
  }
  
  public CartResponse getCartItems(String customerId) {
    List<Cart> cartList = cartRepository.findItemByCustomerId(customerId);
    
    List<Item> items = new ArrayList<>();
    cartList.forEach(cart1 -> {
      Item item = catalogService.getItemById(cart1.getItemId());
      //update the quantity from cart
      item.setQuantity(cart1.getQuantity());
      item.setPrice(cart1.getAmount());
      items.add(item);
    });
    
    CartResponse cartResponse = new CartResponse();
    cartResponse.setCustomerId(customerId);
    
    cartResponse.setItem(items);
    
    return cartResponse;
  }
  
  public Cart getItemInCart(String customerId, long itemId) {
    return cartRepository.findItemByCustomerIdAndItemId(customerId, itemId);
  }
  
  /**
   * Checkout cart items
   * @param customerId
   * @return
   */
  public CheckoutResponse checkout(String customerId) {
    Customer customer = catalogService.getCustomer(customerId);
    if(customer == null){
      return new CheckoutResponse();
    }
    //only send shipping address on checkout
    List<Address> shippingAddress = customer.getAddresses() != null ?
                                    customer.getAddresses().stream().filter(a -> "SHIPPING".equals(a.getType())).collect(Collectors.toList()) : new ArrayList<>();
    
    customer.setAddresses(shippingAddress);
    
    CartResponse cartResponse = getCartItems(customerId);
    double totalPrice = cartResponse != null && cartResponse.getItem() != null ? cartResponse.getItem().stream().mapToDouble(Item::getPrice).sum() : 0.0;
    
    CheckoutResponse checkoutResponse = new CheckoutResponse();
    checkoutResponse.setCustomer(customer);
    checkoutResponse.setItems(cartResponse.getItem());
    checkoutResponse.setTotalAmount(totalPrice);
    
    return checkoutResponse;
  }
}

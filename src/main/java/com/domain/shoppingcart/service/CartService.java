package com.domain.shoppingcart.service;

import com.domain.shoppingcart.model.request.CartRequest;
import com.domain.shoppingcart.model.response.CartResponse;
import com.domain.shoppingcart.model.response.CheckoutResponse;

public interface CartService {
  public CartResponse addToCart(CartRequest cartRequest);
  
  public CartResponse deleteCartItem(CartRequest cartRequest);
  
  public CartResponse getCartItems(String customerId);
  
  public CheckoutResponse checkout(String customerId);
}

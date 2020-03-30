package com.domain.shoppingcart.controller;

import com.domain.shoppingcart.model.request.CartRequest;
import com.domain.shoppingcart.model.response.CartResponse;
import com.domain.shoppingcart.model.response.CheckoutResponse;
import com.domain.shoppingcart.service.CartService;
import com.domain.shoppingcart.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping ("/shopping-cart/cart")
public class CartController {
  
  @Autowired
  private CatalogService catalogService;
  
  @Autowired
  private CartService cartService;
  
  @PostMapping ("/add")
  public ResponseEntity<CartResponse> addToCart(HttpServletResponse response, @RequestBody CartRequest cartRequest) {
    if (cartRequest == null || cartRequest.getCustomerId() == null || cartRequest.getCartItem() == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    CartResponse cartResponse = cartService.addToCart(cartRequest);
    
    return new ResponseEntity<>(cartResponse, HttpStatus.OK);
  }
  
  @DeleteMapping ("/delete")
  public ResponseEntity<CartResponse> deleteItemFromCart(HttpServletResponse response, @RequestBody CartRequest cartRequest) {
    if (cartRequest == null || cartRequest.getCustomerId() == null || cartRequest.getCartItem() == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    CartResponse cartResponse = cartService.deleteCartItem(cartRequest);
    
    return new ResponseEntity<>(cartResponse, HttpStatus.OK);
  }
  
  @GetMapping ("/{customerId}")
  public ResponseEntity<CartResponse> getCartItems(@PathVariable String customerId) {
    CartResponse cartResponse = cartService.getCartItems(customerId);
    
    return new ResponseEntity<>(cartResponse, HttpStatus.OK);
  }
  
  @GetMapping ("/checkout/{customerId}")
  public CheckoutResponse checkout(@PathVariable String customerId) {
    return cartService.checkout(customerId);
  }
}

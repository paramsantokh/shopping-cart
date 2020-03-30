package com.domain.shoppingcart.repository.repo;

import com.domain.shoppingcart.repository.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  
  @Query(value = "SELECT * FROM CART f where f.customer_id = :customerId", nativeQuery = true)
  List<Cart> findItemByCustomerId(@Param ("customerId") String customerId);
  
  @Query(value = "SELECT * FROM CART f where f.customer_id = :customerId and f.item_id = :itemId", nativeQuery = true)
  Cart findItemByCustomerIdAndItemId(@Param ("customerId") String customerId, @Param("itemId") Long itemId);
  
  @Modifying
  @Transactional
  @Query(value = "DELETE FROM CART f where f.customer_id = :customerId", nativeQuery = true)
  Integer deleteItemByCategory(@Param("customerId") String customerId);
  
  @Modifying
  @Transactional
  @Query(value = "DELETE FROM CART f where f.customer_id = :customerId and f.item_id = :itemId", nativeQuery = true)
  Integer deleteItemByCustomerIdAndItemId(@Param("customerId") String customerId, @Param("itemId") Long itemId);
}

package com.domain.shoppingcart.repository.repo;

import com.domain.shoppingcart.repository.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
  
}

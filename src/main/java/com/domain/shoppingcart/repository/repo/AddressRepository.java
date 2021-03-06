package com.domain.shoppingcart.repository.repo;

import com.domain.shoppingcart.repository.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
  
}

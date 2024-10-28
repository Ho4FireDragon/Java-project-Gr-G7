package com.shopkoi.shopkoi.repository;

import com.shopkoi.shopkoi.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUserId(Long userId);
}

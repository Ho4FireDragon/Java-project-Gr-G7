package com.shopkoi.shopkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shopkoi.shopkoi.entity.ServiceEntity;


@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}

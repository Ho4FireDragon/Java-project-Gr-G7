package com.shopkoi.shopkoi.repository;

import com.shopkoi.shopkoi.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByStaffemail(String staffemail);
}

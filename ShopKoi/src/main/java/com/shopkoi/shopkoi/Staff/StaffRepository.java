package com.shopkoi.shopkoi.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    List<Staff> findByStaffname(String staffname); // Trả về danh sách
}

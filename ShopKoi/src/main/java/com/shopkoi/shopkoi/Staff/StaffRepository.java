package com.shopkoi.shopkoi.Staff;

import com.shopkoi.shopkoi.User.User;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff, Integer> {
    // Phương thức để tìm kiếm user theo username
    Staff findByStaffemail(String staffemail);

    // Phương thức kiểm tra xem username đã tồn tại hay chưa
    boolean existsByStaffemail(String staffemail);
}

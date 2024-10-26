package com.shopkoi.shopkoi.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    // Phương thức để tìm kiếm user theo username
    User findByUsername(String username);

    // Phương thức kiểm tra xem username đã tồn tại hay chưa
    boolean existsByUsername(String username);
}

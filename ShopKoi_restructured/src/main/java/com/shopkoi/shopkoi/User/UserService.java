package com.shopkoi.shopkoi.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        // Kiểm tra xem tên người dùng đã tồn tại chưa
        if (user.getId() == 0) { // Nếu ID bằng 0, tức là đây là một người dùng mới
            if (repo.existsByUsername(user.getUsername())) {
                throw new IllegalArgumentException("Tên người dùng đã tồn tại. Vui lòng chọn tên khác.");
            }
        } else {
            // Nếu đã tồn tại, kiểm tra xem có cần cập nhật tên người dùng hay không
            User existingUser = repo.findById(user.getId()).orElseThrow(() -> new NoSuchElementException("User not found"));
            if (!existingUser.getUsername().equals(user.getUsername()) && repo.existsByUsername(user.getUsername())) {
                throw new IllegalArgumentException("Tên người dùng đã tồn tại. Vui lòng chọn tên khác.");
            }
        }

        repo.save(user); // Lưu hoặc cập nhật người dùng vào cơ sở dữ liệu
    }

    // Lấy thông tin một user theo ID
    public User get(int id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    // Xóa user theo ID
    public void delete(int id) {
        repo.deleteById(id);
    }
}

package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.UserService;
import com.shopkoi.shopkoi.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Lấy danh sách tất cả người dùng
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.listAll();
        return ResponseEntity.ok(userList);  // Trả về danh sách người dùng dưới dạng JSON
    }

    // Lấy người dùng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);  // Trả về người dùng theo ID
        } else {
            return ResponseEntity.notFound().build();  // Trả về 404 nếu không tìm thấy người dùng
        }
    }

    // Thêm người dùng mới
    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);  // Trả về người dùng mới tạo
    }

    // Cập nhật người dùng
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User existingUser = userService.getUser(id);
        if (existingUser != null) {
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setFirstname(userDetails.getFirstname());
            existingUser.setLastname(userDetails.getLastname());
            existingUser.setEmail(userDetails.getEmail());

            User updatedUser = userService.saveUser(existingUser);
            return ResponseEntity.ok(updatedUser);  // Trả về người dùng đã cập nhật
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa người dùng theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();  // Trả về 204 No Content sau khi xóa thành công
    }
}

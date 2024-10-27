package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.model.entity.Role;
import com.shopkoi.shopkoi.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")  // Chỉ định định tuyến cho API roles
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Lấy danh sách tất cả các role (GET)
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.listAll();
        return ResponseEntity.ok(roles);  // Trả về danh sách role dưới dạng JSON
    }

    // Thêm role mới (POST)
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role newRole = roleService.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRole);  // Trả về role vừa được tạo
    }

    // Cập nhật role theo ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
        Role existingRole = roleService.get(id);  // Lấy role hiện tại theo ID
        if (existingRole != null) {
            existingRole.setName(roleDetails.getName());  // Cập nhật thông tin role
            Role updatedRole = roleService.save(existingRole);
            return ResponseEntity.ok(updatedRole);  // Trả về role đã cập nhật
        } else {
            return ResponseEntity.notFound().build();  // Trả về mã 404 nếu không tìm thấy role
        }
    }

    // Xóa role theo ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.delete(id);  // Xóa role theo ID
        return ResponseEntity.noContent().build();  // Trả về mã trạng thái 204 khi xóa thành công
    }

    // Lấy role theo ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.get(id);  // Lấy role theo ID
        if (role != null) {
            return ResponseEntity.ok(role);  // Trả về role dưới dạng JSON
        } else {
            return ResponseEntity.notFound().build();  // Trả về mã 404 nếu không tìm thấy
        }
    }
}

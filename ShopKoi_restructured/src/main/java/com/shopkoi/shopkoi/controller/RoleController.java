package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.model.entity.Role;
import com.shopkoi.shopkoi.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Lấy danh sách tất cả các role (GET)
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.listAll();
        return ResponseEntity.ok(roles);
    }

    // Thêm role mới (POST)
    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role newRole = roleService.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRole);
    }

    // Cập nhật role theo ID (PUT)
    @PutMapping("/update/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
        Role existingRole = roleService.get(id);
        if (existingRole != null) {
            existingRole.setName(roleDetails.getName());
            Role updatedRole = roleService.save(existingRole);
            return ResponseEntity.ok(updatedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa role theo ID (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.delete(id);  // Xóa role theo ID
        return ResponseEntity.noContent().build();
    }

    // Lấy role theo ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.get(id);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

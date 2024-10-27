package com.shopkoi.shopkoi.Service;

import com.shopkoi.shopkoi.model.entity.Role;
import com.shopkoi.shopkoi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Lấy tất cả các role
    public List<Role> listAll() {
        return roleRepository.findAll();
    }

    // Lưu role mới hoặc cập nhật role
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    // Lấy role theo ID
    public Role get(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    // Xóa role theo ID
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}

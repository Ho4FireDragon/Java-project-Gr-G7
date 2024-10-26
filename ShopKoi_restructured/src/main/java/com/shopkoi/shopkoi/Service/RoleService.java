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

    public List<Role> listAll() {
        return roleRepository.findAll();
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public Role get(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}

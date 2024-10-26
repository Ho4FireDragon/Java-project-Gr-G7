package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.entity.Role;
import com.shopkoi.shopkoi.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Hiển thị danh sách Role
    @GetMapping
    public String showRoleList(Model model) {
        model.addAttribute("ListRole", roleService.listAll());
        return "role";
    }

    // Form thêm role mới
    @GetMapping("/new")
    public String newRole(Model model) {
        model.addAttribute("Role", new Role());
        return "newrole";
    }

    // Lưu hoặc cập nhật role
    @PostMapping("/save")
    public String saveRole(@ModelAttribute("Role") Role role) {
        roleService.save(role);
        return "redirect:/role";
    }

    // Xóa role theo ID
    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return "redirect:/role";
    }

    // Sửa role theo ID
    @GetMapping("/edit/{id}")
    public String editRole(@PathVariable Long id, Model model) {
        Role role = roleService.get(id);
        model.addAttribute("Role", role);
        return "newrole";
    }
}

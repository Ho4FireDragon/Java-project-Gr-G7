package com.shopkoi.shopkoi.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StaffController {

    @Autowired
    private StaffService service;

    // Hiển thị danh sách staff
    @GetMapping("/staff")
    public String showStaffList(Model model) {
        model.addAttribute("ListStaff", service.listAll());
        return "staff";
    }

    // Tạo staff mới
    @GetMapping("/staff/new")
    public String newStaff(Model model) {
        model.addAttribute("Staff", new Staff());
        return "newstaff";
    }
    // Sửa staff theo ID
    @GetMapping("/staff/editstaff/{id}")
    public String editStaff(@PathVariable int id, Model model) {
        Staff existingStaff = service.getStaff(id);
        if (existingStaff != null) {
            model.addAttribute("Staff", existingStaff); // Lấy thông tin người dùng theo ID
            return "newstaff"; // Sử dụng cùng form để thêm mới và sửa
        } else {
            model.addAttribute("errorMessage", "Staff không tồn tại.");
            return "redirect:/staff";
        }
    }

    // Lưu hoặc cập nhật staff
    @PostMapping("/staff/save")
    public String saveOrUpdateStaff(@ModelAttribute("Staff") Staff staff, RedirectAttributes redirectAttributes) {
        try {
            service.saveStaff(staff); // Lưu hoặc cập nhật staff
            redirectAttributes.addFlashAttribute("message", "Người dùng đã được lưu thành công!");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/staff";
    }

    // Xóa staff theo ID
    @GetMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable int id, RedirectAttributes redirectAttributes) {
        service.delete(id); // Xóa người dùng theo ID
        redirectAttributes.addFlashAttribute("message", "Người dùng đã được xóa thành công!");
        return "redirect:/staff";
    }
}

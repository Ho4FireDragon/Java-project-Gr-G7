package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.RoleService;
import com.shopkoi.shopkoi.Service.StaffService;
import com.shopkoi.shopkoi.entity.Staff;
import com.shopkoi.shopkoi.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/staff")
    public String showStaffList(Model model) {
        model.addAttribute("ListStaff", staffService.listAll());
        return "staff";
    }

    @GetMapping("/staff/new")
    public String newStaff(Model model) {
        model.addAttribute("Staff", new Staff());
        model.addAttribute("roles", roleService.listAll());
        return "newstaff";
    }

    @GetMapping("/staff/editstaff/{id}")
    public String editStaff(@PathVariable int id, Model model) {
        Staff existingStaff = staffService.getStaff(id);
        if (existingStaff != null) {
            model.addAttribute("Staff", existingStaff);
            model.addAttribute("roles", roleService.listAll());
            return "newstaff";
        } else {
            model.addAttribute("errorMessage", "Staff không tồn tại.");
            return "redirect:/staff";
        }
    }

    @PostMapping("/staff/save")
    public String saveOrUpdateStaff(@ModelAttribute("Staff") Staff staff,
                                    @RequestParam("imageFile") MultipartFile imageFile,
                                    RedirectAttributes redirectAttributes) {
        try {
            if (!imageFile.isEmpty()) {
                String fileName = imageFile.getOriginalFilename();
                String uploadDir = "staff-images/";

                if (staff.getImagePath() != null && !staff.getImagePath().isEmpty()) {
                    String oldImagePath = staff.getImagePath();
                    java.io.File oldImageFile = new java.io.File(oldImagePath);
                    if (oldImageFile.exists()) {
                        boolean deleted = oldImageFile.delete();
                        if (!deleted) {
                            System.out.println("Không thể xóa ảnh cũ: " + oldImagePath);
                        }
                    }
                }

                FileUploadUtil.saveFile(uploadDir, fileName, imageFile);
                staff.setImagePath(uploadDir + fileName);
            }

            staffService.saveStaff(staff);
            redirectAttributes.addFlashAttribute("message", "Nhân viên đã được lưu thành công!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi lưu ảnh: " + e.getMessage());
        }
        return "redirect:/staff";
    }

    @GetMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable int id, RedirectAttributes redirectAttributes) {
        staffService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Nhân viên đã được xóa thành công!");
        return "redirect:/staff";
    }
}

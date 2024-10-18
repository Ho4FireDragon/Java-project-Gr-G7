package com.shopkoi.shopkoi.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    // Hiển thị danh sách người dùng
    @GetMapping("/users")
    public String showUsersList(Model model) {
        model.addAttribute("ListUser", service.listAll());
        return "users"; // Đảm bảo template có tên là users.html
    }

    // Hiển thị form thêm người dùng
    @GetMapping("/users/newuser")
    public String addNewUser(Model model) {
        model.addAttribute("User", new User()); // Đưa đối tượng User rỗng vào form
        return "newuser";
    }

    // Lưu người dùng mới
    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("User") User user, RedirectAttributes redirectAttributes) {
        try {
            service.save(user); // Lưu người dùng mới vào cơ sở dữ liệu
            redirectAttributes.addFlashAttribute("message", "Người dùng đã được thêm thành công!");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage()); // Thêm thông báo lỗi
        }
        return "redirect:/users"; // Chuyển hướng về danh sách người dùng sau khi lưu
    }

    // Hiển thị form sửa người dùng
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        model.addAttribute("User", service.get(id)); // Lấy thông tin người dùng theo ID
        return "newuser"; // Sử dụng lại template newuser.html cho form sửa
    }

    // Xóa người dùng
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id, RedirectAttributes redirectAttributes) {
        service.delete(id); // Xóa người dùng theo ID
        redirectAttributes.addFlashAttribute("message", "Người dùng đã được xóa thành công!");
        return "redirect:/users"; // Chuyển hướng về danh sách người dùng sau khi xóa
    }
}

package com.shopkoi.shopkoi.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService Service;
    @GetMapping("/users")
    public String ShowUsersList(Model model) {

        List<User> ListUser = Service.listAll();

        model.addAttribute("ListUser", ListUser);
        return "users";
    }

    @GetMapping("/users/newuser")
    public String AddNewUser(Model model) {
        model.addAttribute("User", new User());
        return "newuser";
    }

}

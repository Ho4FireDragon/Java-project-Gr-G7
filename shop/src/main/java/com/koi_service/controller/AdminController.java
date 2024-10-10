package com.koi_service.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView mav = new ModelAndView("admin");
        return mav;
    }
}

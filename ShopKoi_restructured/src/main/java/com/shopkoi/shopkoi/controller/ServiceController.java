package com.shopkoi.shopkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.shopkoi.shopkoi.service.ServiceService;
import com.shopkoi.shopkoi.entity.ServiceEntity;


import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    // Hiển thị danh sách
    @GetMapping
    public String getAllServices(Model model) {
        List<ServiceEntity> services = serviceService.getAllServices();
        model.addAttribute("services", services);
        return "service";
    }

    // Thêm  mới
    @GetMapping("/new")
    public String showNewServiceForm(Model model) {
        model.addAttribute("service", new ServiceEntity());
        return "newservice";
    }

    @PostMapping
    public String addNewService(@ModelAttribute("service") ServiceEntity service) {
        serviceService.saveService(service);
        return "redirect:/services";
    }

    // Chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditServiceForm(@PathVariable("id") Long id, Model model) {
        ServiceEntity service = serviceService.getServiceById(id);
        model.addAttribute("service", service);
        return "editservice";
    }

    @PostMapping("/update/{id}")
    public String updateService(@PathVariable("id") Long id, @ModelAttribute("service") ServiceEntity service) {
        ServiceEntity existingService = serviceService.getServiceById(id);

        // Cập nhật
        existingService.setNameservice(service.getNameservice());
        existingService.setProductcode(service.getProductcode());
        existingService.setPrice(service.getPrice());
        existingService.setSummary(service.getSummary());
        existingService.setContent(service.getContent());
        existingService.setStatus(service.getStatus());

        serviceService.saveService(existingService);
        return "redirect:/services";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") Long id) {
        serviceService.deleteService(id);
        return "redirect:/services";
    }
}

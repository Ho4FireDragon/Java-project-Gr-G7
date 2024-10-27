package com.shopkoi.shopkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shopkoi.shopkoi.Service.ServiceService;
import com.shopkoi.shopkoi.model.entity.ServiceEntity;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    // Lấy danh sách tất cả các dịch vụ
    @GetMapping
    public ResponseEntity<List<ServiceEntity>> getAllServices() {
        List<ServiceEntity> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);  // Trả về danh sách dịch vụ dưới dạng JSON
    }

    // Thêm dịch vụ mới
    @PostMapping
    public ResponseEntity<ServiceEntity> addNewService(@RequestBody ServiceEntity service) {
        ServiceEntity newService = serviceService.saveService(service);  // Trả về đối tượng ServiceEntity đã lưu
        return ResponseEntity.status(HttpStatus.CREATED).body(newService);  // Trả về dịch vụ mới tạo
    }

    // Cập nhật dịch vụ
    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> updateService(@PathVariable("id") Long id, @RequestBody ServiceEntity service) {
        ServiceEntity existingService = serviceService.getServiceById(id);
        if (existingService != null) {
            // Cập nhật thông tin
            existingService.setNameservice(service.getNameservice());
            existingService.setProductcode(service.getProductcode());
            existingService.setPrice(service.getPrice());
            existingService.setSummary(service.getSummary());
            existingService.setContent(service.getContent());
            existingService.setStatus(service.getStatus());

            ServiceEntity updatedService = serviceService.saveService(existingService);  // Trả về đối tượng đã cập nhật
            return ResponseEntity.ok(updatedService);  // Trả về dịch vụ đã cập nhật
        } else {
            return ResponseEntity.notFound().build();  // Trả về 404 nếu không tìm thấy dịch vụ
        }
    }

    // Xóa dịch vụ theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable("id") Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();  // Trả về 204 No Content sau khi xóa thành công
    }

    // Lấy dịch vụ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntity> getServiceById(@PathVariable("id") Long id) {
        ServiceEntity service = serviceService.getServiceById(id);
        if (service != null) {
            return ResponseEntity.ok(service);  // Trả về dịch vụ theo ID
        } else {
            return ResponseEntity.notFound().build();  // Trả về 404 nếu không tìm thấy dịch vụ
        }
    }
}

package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.shopkoi.shopkoi.Service.ServiceService;
import com.shopkoi.shopkoi.model.entity.ServiceEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    // Lấy danh sách tất cả các dịch vụ
    @GetMapping
    public ResponseEntity<List<ServiceEntity>> getAllServices() {
        List<ServiceEntity> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    // Thêm dịch vụ mới (với ảnh)
    @PostMapping("/create")
    public ResponseEntity<ServiceEntity> addNewService(
            @RequestParam("nameservice") String nameservice,
            @RequestParam("productcode") String productcode,
            @RequestParam("price") Double price,
            @RequestParam("summary") String summary,
            @RequestParam("content") String content,
            @RequestParam("status") ServiceStatus status,
            @RequestParam("image") MultipartFile imageFile) throws IOException {

        String imagePath = saveImage(imageFile);
        ServiceEntity newService = new ServiceEntity();
        newService.setNameservice(nameservice);
        newService.setProductcode(productcode);
        newService.setPrice(price);
        newService.setSummary(summary);
        newService.setContent(content);
        newService.setStatus(status);
        newService.setImagePath(imagePath);

        ServiceEntity savedService = serviceService.saveService(newService);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedService);
    }

    // Cập nhật
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceEntity> updateService(
            @PathVariable("id") Long id,
            @RequestParam("nameservice") String nameservice,
            @RequestParam("productcode") String productcode,
            @RequestParam("price") Double price,
            @RequestParam("summary") String summary,
            @RequestParam("content") String content,
            @RequestParam("status") ServiceStatus status,
            @RequestParam(value = "image", required = false) MultipartFile imageFile) throws IOException {

        ServiceEntity existingService = serviceService.getServiceById(id);
        if (existingService != null) {
            existingService.setNameservice(nameservice);
            existingService.setProductcode(productcode);
            existingService.setPrice(price);
            existingService.setSummary(summary);
            existingService.setContent(content);
            existingService.setStatus(status);

            if (imageFile != null && !imageFile.isEmpty()) {
                String imagePath = saveImage(imageFile);
                existingService.setImagePath(imagePath);
            }

            ServiceEntity updatedService = serviceService.saveService(existingService);
            return ResponseEntity.ok(updatedService);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa dịch vụ theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable("id") Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }

    // Lấy dịch vụ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntity> getServiceById(@PathVariable("id") Long id) {
        ServiceEntity service = serviceService.getServiceById(id);
        if (service != null) {
            return ResponseEntity.ok(service);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Phương thức để lưu ảnh vào thư mục
    private String saveImage(MultipartFile imageFile) throws IOException {
        // Tạo tên file duy nhất để tránh trùng lặp
        String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        String uploadDir = "staff-images/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);  // Tạo thư mục nếu chưa tồn tại
        }

        // Lưu file vào thư mục
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(imageFile.getInputStream(), filePath);
        return uploadDir + fileName;
    }
}

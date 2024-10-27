package com.shopkoi.shopkoi.controller;

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
        return ResponseEntity.ok(services);  // Trả về danh sách dịch vụ dưới dạng JSON
    }

    // Thêm dịch vụ mới (với ảnh)
    @PostMapping
    public ResponseEntity<ServiceEntity> addNewService(
            @RequestParam("nameservice") String nameservice,
            @RequestParam("productcode") String productcode,
            @RequestParam("price") Double price,
            @RequestParam("summary") String summary,
            @RequestParam("content") String content,
            @RequestParam("status") String status,
            @RequestParam("image") MultipartFile imageFile) throws IOException {

        // Lưu file ảnh và trả về đường dẫn
        String imagePath = saveImage(imageFile);

        // Tạo đối tượng ServiceEntity và thiết lập giá trị
        ServiceEntity newService = new ServiceEntity();
        newService.setNameservice(nameservice);
        newService.setProductcode(productcode);
        newService.setPrice(price);
        newService.setSummary(summary);
        newService.setContent(content);
        newService.setStatus(status);
        newService.setImagePath(imagePath);  // Lưu đường dẫn ảnh vào cơ sở dữ liệu

        ServiceEntity savedService = serviceService.saveService(newService);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedService);  // Trả về dịch vụ mới tạo
    }

    // Cập nhật dịch vụ
    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> updateService(
            @PathVariable("id") Long id,
            @RequestParam("nameservice") String nameservice,
            @RequestParam("productcode") String productcode,
            @RequestParam("price") Double price,
            @RequestParam("summary") String summary,
            @RequestParam("content") String content,
            @RequestParam("status") String status,
            @RequestParam(value = "image", required = false) MultipartFile imageFile) throws IOException {

        ServiceEntity existingService = serviceService.getServiceById(id);
        if (existingService != null) {
            // Cập nhật thông tin
            existingService.setNameservice(nameservice);
            existingService.setProductcode(productcode);
            existingService.setPrice(price);
            existingService.setSummary(summary);
            existingService.setContent(content);
            existingService.setStatus(status);

            // Nếu có ảnh mới, cập nhật đường dẫn ảnh
            if (imageFile != null && !imageFile.isEmpty()) {
                String imagePath = saveImage(imageFile);
                existingService.setImagePath(imagePath);
            }

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

    // Phương thức để lưu ảnh vào thư mục
    private String saveImage(MultipartFile imageFile) throws IOException {
        // Tạo tên file duy nhất để tránh trùng lặp
        String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();

        // Đường dẫn thư mục nơi lưu ảnh (thư mục này cần tồn tại)
        String uploadDir = "staff-images/";
        Path uploadPath = Paths.get(uploadDir);

        // Kiểm tra xem thư mục có tồn tại hay không, nếu không thì tạo mới
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);  // Tạo thư mục nếu chưa tồn tại
        }

        // Lưu file vào thư mục
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(imageFile.getInputStream(), filePath);

        // Trả về đường dẫn ảnh
        return uploadDir + fileName;
    }
}

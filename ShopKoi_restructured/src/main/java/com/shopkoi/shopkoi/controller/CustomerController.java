package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.CustomerService;
import com.shopkoi.shopkoi.model.entity.Customer;
import com.shopkoi.shopkoi.model.entity.User;
import com.shopkoi.shopkoi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserRepository userRepository;

    // Lấy danh sách tất cả khách hàng
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    // Tạo mới một khách hàng
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Map<String, Object> customerData) {
        // Kiểm tra xem các trường bắt buộc có tồn tại trong dữ liệu yêu cầu không
        if (!customerData.containsKey("userId") || !customerData.containsKey("phone") || !customerData.containsKey("address")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing required fields: userId, phone, or address");
        }

        Long userId;
        String phone;
        String address;

        try {
            userId = Long.valueOf(customerData.get("userId").toString());
            phone = customerData.get("phone").toString();
            address = customerData.get("address").toString();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input data");
        }

        // Lấy thông tin user từ userId
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }

        // Kiểm tra nếu Customer đã tồn tại cho userId
        Customer existingCustomer = customerService.findByUserId(userId);
        if (existingCustomer != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Customer already exists for this user.");
        }

        // Tạo customer từ user và bổ sung thêm phone, address
        Customer customer = customerService.createCustomerFromUser(user, phone, address);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    // Lấy thông tin một khách hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Cập nhật thông tin khách hàng theo ID
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long id,
            @RequestBody Map<String, Object> customerData) {

        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Kiểm tra các trường phone và address có tồn tại không
        if (!customerData.containsKey("phone") || !customerData.containsKey("address")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        String phone = customerData.get("phone").toString();
        String address = customerData.get("address").toString();

        customer.setPhone(phone);
        customer.setAddress(address);

        // Cập nhật thông tin khách hàng trong CSDL
        Customer updatedCustomer = customerService.saveCustomer(customer);

        return ResponseEntity.ok(updatedCustomer);
    }

    // Xóa khách hàng theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}

package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.CustomerService;
import com.shopkoi.shopkoi.model.entity.Customer;
import com.shopkoi.shopkoi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;



    // Lấy danh sách tất cả khách hàng
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    // Tạo mới một khách hàng
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        // Kiểm tra xem thông tin khách hàng có hợp lệ không
        if (customer.getFirstname() == null || customer.getLastname() == null || customer.getEmail() == null) {
            return ResponseEntity.badRequest().build(); // Trả về lỗi nếu thông tin không hợp lệ
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        // Lưu thông tin khách hàng mới
        Customer createdCustomer = customerService.saveCustomer(customer);

        // Trả về phản hồi với mã trạng thái 201 (Created) và thông tin khách hàng mới
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
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

    // Cập nhật thông tin khách hàng
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer != null) {
            // Cập nhật các thông tin khác của khách hàng
            existingCustomer.setFirstname(customerDetails.getFirstname());
            existingCustomer.setLastname(customerDetails.getLastname());
            existingCustomer.setEmail(customerDetails.getEmail());

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

            // Kiểm tra nếu mật khẩu có thay đổi
            if (!passwordEncoder.matches(customerDetails.getPassword(), existingCustomer.getPassword())) {
                existingCustomer.setPassword(passwordEncoder.encode(customerDetails.getPassword()));
            }

            // Lưu thay đổi vào cơ sở dữ liệu
            Customer updatedCustomer = customerService.saveCustomer(existingCustomer);
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build(); // Trả về mã lỗi 404 nếu khách hàng không tồn tại
        }
    }


    // Cập nhật mật khẩu cho khách hàng
    @PutMapping("/update-password/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable Long id, @RequestBody Map<String, String> request) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            String newPassword = request.get("newPassword");

            // Kiểm tra xem mật khẩu mới có tồn tại trong yêu cầu không
            if (newPassword == null || newPassword.isEmpty()) {
                return ResponseEntity.badRequest().body("New password is required");
            }

            // Mã hóa mật khẩu mới
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            customer.setPassword(passwordEncoder.encode(newPassword));

            // Lưu mật khẩu mới
            customerService.saveCustomer(customer);

            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
    }



    // Xóa khách hàng theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}


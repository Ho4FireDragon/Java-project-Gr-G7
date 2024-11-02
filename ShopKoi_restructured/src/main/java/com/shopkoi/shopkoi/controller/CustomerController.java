package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.CustomerService;
import com.shopkoi.shopkoi.model.entity.Customer;
import com.shopkoi.shopkoi.repository.CustomerRepository;
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
        Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Xóa khách hàng theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}


package com.shopkoi.shopkoi.Service;

import com.shopkoi.shopkoi.model.entity.Customer;
import com.shopkoi.shopkoi.model.entity.User;
import com.shopkoi.shopkoi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Hàm lưu hoặc cập nhật thông tin khách hàng
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Hàm lấy tất cả khách hàng
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Hàm lấy khách hàng theo ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    // Hàm tạo mới khách hàng từ User
    public Customer createCustomerFromUser(User user, String phone, String address) {
        Customer customer = new Customer();
        customer.setFirstname(user.getFirstname());
        customer.setLastname(user.getLastname());
        customer.setEmail(user.getEmail());
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setUser(user); // Gán User vào Customer

        return customerRepository.save(customer);
    }

    // Hàm xóa khách hàng
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Hàm tìm khách hàng theo userId
    public Customer findByUserId(Long userId) {
        return customerRepository.findByUserId(userId);
    }
}

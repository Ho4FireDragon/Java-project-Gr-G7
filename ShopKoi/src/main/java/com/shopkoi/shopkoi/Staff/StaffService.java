package com.shopkoi.shopkoi.Staff;

import com.shopkoi.shopkoi.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StaffService {
    @Autowired private StaffRepository staffRepo;

    public List<Staff> listAll() {
        return (List<Staff>) staffRepo.findAll();
    }

    public void saveStaff(Staff staff) {
        staffRepo.save(staff); // Lưu hoặc cập nhật người dùng vào cơ sở dữ liệu
    }

    public Staff getStaff(int staffid) {
        return staffRepo.findById(staffid).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    // Xóa user theo ID
    public void delete(int staffid) {
        staffRepo.deleteById(staffid);
    }
}

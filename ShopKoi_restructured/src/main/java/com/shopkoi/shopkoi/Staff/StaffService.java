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
    //chức năng edit đã sửa
    public void saveStaff(Staff staff) {
        // Kiểm tra xem tên người dùng đã tồn tại hay chưa
        List<Staff> existingStaff = staffRepo.findByStaffname(staff.getStaffname());

        // Nếu có người dùng cũ, xóa họ
        if (!existingStaff.isEmpty()) {
            for (Staff oldStaff : existingStaff) {
                staffRepo.delete(oldStaff); // Xóa người dùng cũ
            }
        }

        // Lưu hoặc cập nhật người dùng mới vào cơ sở dữ liệu
        staffRepo.save(staff);
    }


    public Staff getStaff(int staffid) {
        return staffRepo.findById(staffid).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    // Xóa user theo ID
    public void delete(int staffid) {
        staffRepo.deleteById(staffid);
    }
}

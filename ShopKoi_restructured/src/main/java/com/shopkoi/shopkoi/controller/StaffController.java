package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.StaffService;
import com.shopkoi.shopkoi.model.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    // Lấy danh sách tất cả nhân viên
    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> staffList = staffService.listAll();
        return ResponseEntity.ok(staffList);  // Trả về danh sách nhân viên dưới dạng JSON
    }

    // Lấy nhân viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Staff staff = staffService.getStaff(id);
        if (staff != null) {
            return ResponseEntity.ok(staff);  // Trả về nhân viên theo ID
        } else {
            return ResponseEntity.notFound().build();  // Trả về 404 nếu không tìm thấy nhân viên
        }
    }

    // Thêm nhân viên mới
    @PostMapping
    public ResponseEntity<Staff> addNewStaff(@RequestBody Staff staff) {
        Staff newStaff = staffService.saveStaff(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStaff);  // Trả về nhân viên mới tạo
    }

    // Cập nhật nhân viên
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staffDetails) {
        Staff existingStaff = staffService.getStaff(id);
        if (existingStaff != null) {
            existingStaff.setStaffname(staffDetails.getStaffname());
            existingStaff.setStaffemail(staffDetails.getStaffemail());
            existingStaff.setStaffphone(staffDetails.getStaffphone());
            existingStaff.setRole(staffDetails.getRole());

            Staff updatedStaff = staffService.saveStaff(existingStaff);
            return ResponseEntity.ok(updatedStaff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa nhân viên theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.delete(id);
        return ResponseEntity.noContent().build();  // Trả về 204 No Content sau khi xóa thành công
    }
}

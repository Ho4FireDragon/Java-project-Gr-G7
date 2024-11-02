package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.RoleService;
import com.shopkoi.shopkoi.Service.StaffService;
//import com.shopkoi.shopkoi.Service.StaffSchedule;
import com.shopkoi.shopkoi.dto.StaffRequest;
import com.shopkoi.shopkoi.model.entity.Role;
import com.shopkoi.shopkoi.model.entity.Staff;
import com.shopkoi.shopkoi.repository.RoleRepository;
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

//    @Autowired
//    private StaffSchedule staffSchedule;

    @Autowired
    private RoleService roleService;

    @Autowired
    RoleRepository roleRepository;

    // Lấy danh sách tất cả nhân viên
    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> staffList = staffService.listAll();
        return ResponseEntity.ok(staffList);
    }

//    // Lấy danh sách tất cả các giá trị của StaffSchedule
//    @GetMapping("/schedules")
//    public ResponseEntity<List<StaffSchedule>> getAllSchedules() {
//        return ResponseEntity.ok(List.of(StaffSchedule.values()));
//    }

    // Lấy nhân viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Staff staff = staffService.getStaff(id);
        if (staff != null) {
            return ResponseEntity.ok(staff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Thêm nhân viên mới



        @PostMapping("/create")
        public ResponseEntity<Staff> addNewStaff(@RequestBody StaffRequest staffRequest) {
            // Fetch the Role by roleId
            Role role = roleRepository.getById(staffRequest.getRoleId());
            if (role == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Return bad request if role not found
            }

            // Create a new Staff entity from StaffRequest data
            Staff newStaff = new Staff();
            newStaff.setStaffname(staffRequest.getStaffName());
            newStaff.setStaffemail(staffRequest.getStaffEmail());
            newStaff.setStaffphone(staffRequest.getStaffPhone());
            newStaff.setRole(role); // Set the fetched Role object
            newStaff.setStaffschedule(staffRequest.getStaffSchedule());
            newStaff.setStaffpassword(staffRequest.getStaffPassword());

            // Save the new staff entity
            Staff savedStaff = staffService.saveStaff(newStaff);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStaff);
        }

    // Cập nhật nhân viên
    @PutMapping("/update/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody StaffRequest staffRequest) {
        Staff existingStaff = staffService.getStaff(id);
        if (existingStaff != null) {
            // Lấy role từ roleId trong StaffRequest
            Role role = roleService.get(staffRequest.getRoleId());
            if (role == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Nếu role không tồn tại, trả về mã lỗi 400
            }

            // Cập nhật thông tin nhân viên dựa trên StaffRequest
            existingStaff.setStaffname(staffRequest.getStaffName());
            existingStaff.setStaffemail(staffRequest.getStaffEmail());
            existingStaff.setStaffphone(staffRequest.getStaffPhone());
            existingStaff.setRole(role); // Gán Role đã tìm được
            existingStaff.setStaffschedule(staffRequest.getStaffSchedule());
            existingStaff.setStaffpassword(staffRequest.getStaffPassword());

            // Lưu thay đổi
            Staff updatedStaff = staffService.saveStaff(existingStaff);
            return ResponseEntity.ok(updatedStaff);
        } else {
            return ResponseEntity.notFound().build(); // Trả về mã lỗi 404 nếu nhân viên không tồn tại
        }
    }



        // Xóa nhân viên theo ID
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.delete(id);
            return ResponseEntity.noContent().build();
        }

}



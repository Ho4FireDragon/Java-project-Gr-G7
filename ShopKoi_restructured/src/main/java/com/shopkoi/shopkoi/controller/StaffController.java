
package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.StaffService;
//import com.shopkoi.shopkoi.Service.StaffSchedule;
import com.shopkoi.shopkoi.dto.StaffRequest;
import com.shopkoi.shopkoi.model.entity.Staff;
import com.shopkoi.shopkoi.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private StaffRepository staffRepository;

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
    public ResponseEntity<?> addNewStaff(@RequestBody StaffRequest staffRequest) {
        // Kiểm tra nếu email đã tồn tại trong cơ sở dữ liệu
        if (staffRepository.existsByStaffemail(staffRequest.getStaffEmail())) {
            // Trả về thông báo lỗi
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists");
        }

        // Tạo đối tượng Staff từ StaffRequest
        Staff newStaff = new Staff();
        newStaff.setStaffname(staffRequest.getStaffName());
        newStaff.setStaffemail(staffRequest.getStaffEmail());
        newStaff.setStaffphone(staffRequest.getStaffPhone());
        newStaff.setStaffschedule(staffRequest.getStaffSchedule());
        newStaff.setProfilephoto(staffRequest.getProfilephoto());
        newStaff.setStaffpassword(staffRequest.getStaffPassword());

        // Mã hóa mật khẩu trước khi lưu
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        newStaff.setStaffpassword(passwordEncoder.encode(newStaff.getStaffpassword()));

        // Lưu staff vào cơ sở dữ liệu
        Staff savedStaff = staffService.saveStaff(newStaff);

        // Trả về phản hồi thành công
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStaff);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staffRequest) {
        Staff existingStaff = staffService.getStaff(id);

        if (existingStaff == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Nhân viên không tồn tại
        }

        // Kiểm tra và cập nhật thông tin nhân viên
        existingStaff.setStaffname(staffRequest.getStaffname());
        existingStaff.setStaffemail(staffRequest.getStaffemail());
        existingStaff.setStaffphone(staffRequest.getStaffphone());
        existingStaff.setStaffschedule(staffRequest.getStaffschedule());
        existingStaff.setProfilephoto(staffRequest.getProfilephoto());

        // Nếu mật khẩu không null hoặc không rỗng, kiểm tra và cập nhật
        if (staffRequest.getStaffpassword() != null && !staffRequest.getStaffpassword().isEmpty()) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

            // Chỉ cập nhật nếu mật khẩu thay đổi
            if (!passwordEncoder.matches(staffRequest.getStaffpassword(), existingStaff.getStaffpassword())) {
                existingStaff.setStaffpassword(passwordEncoder.encode(staffRequest.getStaffpassword()));
            }
        }

        // Lưu nhân viên đã cập nhật
        Staff updatedStaff = staffService.saveStaff(existingStaff);

        return ResponseEntity.ok(updatedStaff);
    }




    // API để cập nhật mật khẩu
    @PutMapping("/update-password/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable Long id, @RequestBody String newPassword) {
        Staff existingStaff = staffService.getStaff(id);
        if (existingStaff != null) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            // Mã hóa mật khẩu mới
            existingStaff.setStaffpassword(passwordEncoder.encode(newPassword));
            // Lưu thay đổi
            staffService.saveStaff(existingStaff);
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }
    }



    // Xóa nhân viên theo ID
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.delete(id);
            return ResponseEntity.noContent().build();
        }

}



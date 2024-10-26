package com.shopkoi.shopkoi.Service;

import com.shopkoi.shopkoi.entity.Staff;
import com.shopkoi.shopkoi.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> listAll() {
        return staffRepository.findAll();
    }

    public void saveStaff(Staff staff) {
        staffRepository.save(staff);
    }

    public Staff getStaff(int id) {
        return staffRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        staffRepository.deleteById(id);
    }
}

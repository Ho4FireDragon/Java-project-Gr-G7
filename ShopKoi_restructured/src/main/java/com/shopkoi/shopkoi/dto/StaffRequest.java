package com.shopkoi.shopkoi.dto;

import com.shopkoi.shopkoi.Service.StaffSchedule;
import lombok.Getter;

@Getter
public class StaffRequest {
    private String staffName;
    private String staffEmail;
    private String staffPhone;
    private Long roleId;
    private StaffSchedule staffSchedule;
    private String staffPassword;

    public StaffRequest(String staffName, String staffEmail, String staffPhone, Long roleId, StaffSchedule staffSchedule, String staffPassword) {
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.staffPhone = staffPhone;
        this.roleId = roleId;
        this.staffSchedule = staffSchedule;
        this.staffPassword = staffPassword;
    }

    public StaffRequest() {}

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setStaffSchedule(StaffSchedule staffSchedule) {
        this.staffSchedule = staffSchedule;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }
}

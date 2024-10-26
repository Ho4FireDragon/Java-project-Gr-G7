package com.shopkoi.shopkoi.model.entity;  // Đảm bảo package đúng

import jakarta.persistence.*;

@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffid;

    @Column(nullable = false)
    private String staffname;

    @Column(nullable = false)
    private String staffphone;

    @Column(nullable = false)
    private String staffemail;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String staffschdule;

    @Column(nullable = false)
    private String staffpassword;

    // Thêm thuộc tính mới cho đường dẫn ảnh
    @Column()
    private String imagePath;

    // Getter và Setter cho imagePath
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Các getter và setter khác
    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffphone() {
        return staffphone;
    }

    public void setStaffphone(String staffphone) {
        this.staffphone = staffphone;
    }

    public String getStaffemail() {
        return staffemail;
    }

    public void setStaffemail(String staffemail) {
        this.staffemail = staffemail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStaffschdule() {
        return staffschdule;
    }

    public void setStaffschdule(String staffschdule) {
        this.staffschdule = staffschdule;
    }

    public String getStaffpassword() {
        return staffpassword;
    }

    public void setStaffpassword(String staffpassword) {
        this.staffpassword = staffpassword;
    }
}

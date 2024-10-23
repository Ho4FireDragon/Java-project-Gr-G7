package com.shopkoi.shopkoi.Staff;

import jakarta.persistence.*;

@Entity
@Table(name="staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffid;

    @Column ()
    private String staffname;

    @Column()
    private String staffphone;

    @Column()
    private String staffemail;

    @Column()
    private String role;

    @Column()
    private String staffschdule;

    @Column()
    private String staffpassword;

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

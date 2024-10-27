package com.shopkoi.shopkoi.model.entity;

import jakarta.persistence.*;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String staffname;
    private String staffemail;
    private String staffphone;

    @ManyToOne
    @JoinColumn(name = "role_id")  // Mapping với entity Role
    private Role role;

    public Staff() {
    }

    public Staff(Long id, String staffname, String staffemail, String staffphone, Role role) {
        this.id = id;
        this.staffname = staffname;
        this.staffemail = staffemail;
        this.staffphone = staffphone;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffemail() {
        return staffemail;
    }

    public void setStaffemail(String staffemail) {
        this.staffemail = staffemail;
    }

    public String getStaffphone() {
        return staffphone;
    }

    public void setStaffphone(String staffphone) {
        this.staffphone = staffphone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

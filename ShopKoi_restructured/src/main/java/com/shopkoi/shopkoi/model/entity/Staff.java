package com.shopkoi.shopkoi.model.entity;

import com.shopkoi.shopkoi.Service.Right;
import com.shopkoi.shopkoi.Service.StaffSchedule;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff")
public class Staff {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String staffname;
    private String staffemail;
    private String staffphone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")  // Mapping với entity Role
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // Bỏ qua các thuộc tính proxy khi chuyển đổi JSON
    private Role role;

    private String staffadress;

    @ElementCollection(targetClass = StaffSchedule.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "staffschedule")
    private Set<StaffSchedule> staffschedule;

    private String staffpassword;


    @Enumerated(EnumType.STRING)
    @Column(name = "rightstaff")
    private Right rightstaff;

}

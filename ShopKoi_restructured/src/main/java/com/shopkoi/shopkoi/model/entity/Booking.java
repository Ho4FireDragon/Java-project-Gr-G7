package com.shopkoi.shopkoi.model.entity;

import com.shopkoi.shopkoi.Service.PaymentMethod;
import com.shopkoi.shopkoi.Service.StaffSchedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id",nullable = true)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "service_id",nullable = true)
    private ServiceEntity service;

    private String bookingDate;

    private String bookingDetail;

    private Double distance;

    @Enumerated(EnumType.STRING)
    @Column
    private PaymentMethod paymentMethod;

    private boolean isAppointment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id")
    private Set<Medicine> medical;


}



package com.shopkoi.shopkoi.model.entity;

import com.shopkoi.shopkoi.Service.PaymentMethod;
import com.shopkoi.shopkoi.Service.StaffSchedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
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


    public Booking(Customer customer, Staff staff, ServiceEntity service, String bookingDate, String bookingDetail, Double distance, PaymentMethod paymentMethod) {
        this.customer = customer;
        this.staff = staff;
        this.service = service;
        this.bookingDate = bookingDate;
        this.bookingDetail = bookingDetail;
        this.distance = distance;
        this.paymentMethod = paymentMethod;
    }
}



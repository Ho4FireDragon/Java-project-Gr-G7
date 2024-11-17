package com.shopkoi.shopkoi.model.entity;

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
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    private String bookingDate;

    private String bookingDetail;

    private Double distance;

    public Booking(Customer customer, Staff staff, ServiceEntity service, String bookingDate, String bookingDetail, Double distance) {
        this.customer = customer;
        this.staff = staff;
        this.service = service;
        this.bookingDate = bookingDate;
        this.bookingDetail = bookingDetail;
        this.distance = distance;
    }
}

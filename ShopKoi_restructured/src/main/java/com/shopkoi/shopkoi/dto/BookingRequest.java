package com.shopkoi.shopkoi.dto;

public class BookingRequest {
    private Long userId;
    private Long staffId;
    private Long serviceId;
    private String bookingDate;
    private String phone;
    private String address;

    // Constructors, getters, and setters
    public BookingRequest() {}

    public BookingRequest(Long userId, Long staffId, Long serviceId, String bookingDate, String phone, String address) {
        this.userId = userId;
        this.staffId = staffId;
        this.serviceId = serviceId;
        this.bookingDate = bookingDate;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

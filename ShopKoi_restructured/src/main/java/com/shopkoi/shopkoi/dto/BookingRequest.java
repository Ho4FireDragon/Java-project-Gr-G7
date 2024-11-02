package com.shopkoi.shopkoi.dto;

public class BookingRequest {
    private Long customerId;
    private Long staffId;
    private Long serviceId;
    private String bookingDate;


    public BookingRequest(Long customerId, Long staffId, Long serviceId, String bookingDate, String phone, String address, String password) {
        this.customerId = customerId;
        this.staffId = staffId;
        this.serviceId = serviceId;
        this.bookingDate = bookingDate;

    }

   public BookingRequest() {}

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

}

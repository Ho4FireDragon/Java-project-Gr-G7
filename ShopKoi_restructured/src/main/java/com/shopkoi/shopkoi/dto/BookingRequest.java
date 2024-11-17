package com.shopkoi.shopkoi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class BookingRequest {
    private Long customerId;
    private Long staffId;
    private Long serviceId;
    private String bookingDate;
    private String bookingDetail;
    private Double distance;

    public BookingRequest(Long customerId, Long staffId, Long serviceId, String bookingDate, String bookingDetail, Double distance) {
        this.customerId = customerId;
        this.staffId = staffId;
        this.serviceId = serviceId;
        this.bookingDate = bookingDate;
        this.bookingDetail = bookingDetail;
        this.distance = distance;
    }
}

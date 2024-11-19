package com.shopkoi.shopkoi.dto;

import com.shopkoi.shopkoi.Service.PaymentMethod;
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
    private PaymentMethod paymentMethod;

    public BookingRequest(Long customerId, Long staffId, Long serviceId, String bookingDate, String bookingDetail, Double distance, PaymentMethod paymentMethod) {
        this.customerId = customerId;
        this.staffId = staffId;
        this.serviceId = serviceId;
        this.bookingDate = bookingDate;
        this.bookingDetail = bookingDetail;
        this.distance = distance;
        this.paymentMethod = paymentMethod;
    }
}

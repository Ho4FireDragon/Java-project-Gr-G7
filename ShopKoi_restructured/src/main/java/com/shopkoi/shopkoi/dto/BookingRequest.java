<<<<<<< HEAD
package com.shopkoi.shopkoi.dto;

import com.shopkoi.shopkoi.Service.PaymentMethod;
import com.shopkoi.shopkoi.model.entity.Medicine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookingRequest {
    private Long customerId;
    private Long staffId;
    private Long serviceId;
    private String bookingDate;
    private String bookingDetail;
    private Double distance;
    private PaymentMethod paymentMethod;

    private Set<Long> medicalid;

}
=======
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
>>>>>>> 6862fd5b29ebec6ad5799e7f67a392adfcf9d083

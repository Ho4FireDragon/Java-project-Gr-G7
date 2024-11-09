package com.shopkoi.shopkoi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedbackRequest {
    private Long bookingid;
    private Long customerid;
    private int rating;
    private String comment;

    public FeedbackRequest() {}

    public FeedbackRequest(Long bookingid, Long customerid, int rating, String comment) {
        this.bookingid = bookingid;
        this.customerid = customerid;
        this.rating = rating;
        this.comment = comment;
    }

}

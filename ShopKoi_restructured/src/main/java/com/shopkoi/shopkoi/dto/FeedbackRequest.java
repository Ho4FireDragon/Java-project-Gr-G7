package com.shopkoi.shopkoi.dto;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public Long getBookingid() {
        return bookingid;
    }

    public void setBookingid(Long bookingid) {
        this.bookingid = bookingid;
    }

}

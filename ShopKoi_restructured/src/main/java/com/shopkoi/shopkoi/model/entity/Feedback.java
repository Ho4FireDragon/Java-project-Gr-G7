package com.shopkoi.shopkoi.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackid;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column()
    private int rating;

    @Column
    private String comment;

    public Feedback(Long feedbackid, Booking booking, Customer customer, int rating, String comment) {
        this.feedbackid = feedbackid;
        this.booking = booking;
        this.customer = customer;
        this.rating = rating;
        this.comment = comment;
    }

    public Feedback(Booking booking, Customer customer, int rating, String comment) {
        this.booking = booking;
        this.customer = customer;
        this.rating = rating;
        this.comment = comment;
    }

    public Feedback() {
    }

    public Long getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(Long feedbackid) {
        this.feedbackid = feedbackid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

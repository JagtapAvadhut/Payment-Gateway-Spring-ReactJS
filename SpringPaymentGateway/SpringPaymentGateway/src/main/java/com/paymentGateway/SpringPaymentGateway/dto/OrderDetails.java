package com.paymentGateway.SpringPaymentGateway.dto;

public class OrderDetails {
    private String orderId;
    private String razorpayPaymentId;
    private String razorpayOrderId;
    private String razorpaySignature;
    // Add other order-related information as needed

    public OrderDetails() {
        // Default constructor
    }

    public OrderDetails(String orderId, String razorpayPaymentId, String razorpayOrderId, String razorpaySignature) {
        this.orderId = orderId;
        this.razorpayPaymentId = razorpayPaymentId;
        this.razorpayOrderId = razorpayOrderId;
        this.razorpaySignature = razorpaySignature;
    }

    // Getters and setters for the fields
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRazorpayPaymentId() {
        return razorpayPaymentId;
    }

    public void setRazorpayPaymentId(String razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public String getRazorpaySignature() {
        return razorpaySignature;
    }

    public void setRazorpaySignature(String razorpaySignature) {
        this.razorpaySignature = razorpaySignature;
    }

    // Override toString() method for debugging purposes
    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId='" + orderId + '\'' +
                ", razorpayPaymentId='" + razorpayPaymentId + '\'' +
                ", razorpayOrderId='" + razorpayOrderId + '\'' +
                ", razorpaySignature='" + razorpaySignature + '\'' +
                '}';
    }
}

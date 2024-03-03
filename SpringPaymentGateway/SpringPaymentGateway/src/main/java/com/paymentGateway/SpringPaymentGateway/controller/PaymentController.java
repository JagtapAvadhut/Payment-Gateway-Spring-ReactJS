package com.paymentGateway.SpringPaymentGateway.controller;

import com.paymentGateway.SpringPaymentGateway.dto.OrderDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

    @Value("${Razorpay.key_id}")
    private String razorpayKeyId;

    @Value("${Razorpay.key_secret}")
    private String razorpayKeySecret;

    @PostMapping("/orders")
    public String createOrder(@RequestBody Map<String,String> requestData) {
        try {
            RazorpayClient razorpay = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
            double amount = Integer.parseInt(requestData.get("amount"));
            String receipt =  requestData.get("receipt");
            String currency =   requestData.get("currency");
//            String currency = requestData.getCurrency();
//            String receipt = requestData.getReceipt();

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount * 100); // converting amount to paise
            orderRequest.put("currency", currency);
            orderRequest.put("receipt",receipt);
//            orderRequest.put("amount", requestData.getInt("amount") * 100); // converting amount to paise
//            orderRequest.put("currency", requestData.getString("currency"));
//            orderRequest.put("receipt", requestData.getString("receipt"));

            Order order = razorpay.orders.create(orderRequest);
            System.out.println("Order created: " + order);
            return order.toString();
        } catch (RazorpayException e) {
            e.printStackTrace();
            return "Error occurred while creating order: " + e.getMessage();
        }
    }
    @PostMapping("/order-details")
    public ResponseEntity<String> handleOrderDetails(@RequestBody OrderDetails orderDetails) {
        try {
            // Extract order details from the request body
            String orderId = orderDetails.getOrderId();
            String razorpayPaymentId = orderDetails.getRazorpayPaymentId();
            String razorpayOrderId = orderDetails.getRazorpayOrderId();
            String razorpaySignature = orderDetails.getRazorpaySignature();
            // Add other order-related information as needed

            // Perform any necessary business logic, such as storing the order details in a database
            System.out.println("Order Details \t\t\t:"+orderDetails);
            // Return a success response
            return ResponseEntity.ok("Order details processed successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while processing order details: " + e.getMessage());
        }
    }
}

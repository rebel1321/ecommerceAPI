package com.satya.ecommerce_satya.controller;

import com.satya.ecommerce_satya.exception.OrderException;
import com.satya.ecommerce_satya.exception.UserException;
import com.satya.ecommerce_satya.model.Address;
import com.satya.ecommerce_satya.model.Order;
import com.satya.ecommerce_satya.model.User;
import com.satya.ecommerce_satya.service.OrderService;
import com.satya.ecommerce_satya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Order>createOrder(@RequestBody Address shippingAddress,
                                            @RequestHeader("Authorization") String jwt)throws UserException{
        User user =userService.findUserprofileByJwt(jwt);
        Order order=orderService.createOrder(user,shippingAddress);
        System.out.println("order"+order);


        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<List<Order>> userOrderHistory(@RequestHeader("Authorization") String jwt)throws UserException{
        User user =userService.findUserprofileByJwt(jwt);
        List<Order> orders=orderService.userOrderHistory(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Order> findOrderById(@PathVariable("Id") Long orderId,@RequestHeader("Authorization") String jwt)throws UserException, OrderException {
        User user =userService.findUserprofileByJwt(jwt);
        Order order=orderService.findOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }

}

package com.satya.ecommerce_satya.service;

import com.satya.ecommerce_satya.exception.OrderException;
import com.satya.ecommerce_satya.model.Address;
import com.satya.ecommerce_satya.model.Order;
import com.satya.ecommerce_satya.model.User;

import java.util.List;

public interface OrderService {

    public Order createOrder(User user, Address shippingAddress);
    public Order findOrderById(Long orderId) throws OrderException;
    public List<Order> userOrderHistory(Long userId);
    public Order placedOrder(Long orderId) throws OrderException;
    public Order confirmedOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order canceledOrder(Long orderId) throws OrderException;
    public List<Order> getAllOrders();
    public void deleteOrder(Long orderId) throws OrderException;
}

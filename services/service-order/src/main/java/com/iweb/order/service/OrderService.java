package com.iweb.order.service;


import com.iweb.order.Order;

public interface OrderService {
    Order createOrder(Long productId, Long userId);
}

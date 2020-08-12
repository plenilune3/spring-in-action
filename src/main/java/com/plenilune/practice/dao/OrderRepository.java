package com.plenilune.practice.dao;

import com.plenilune.practice.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}

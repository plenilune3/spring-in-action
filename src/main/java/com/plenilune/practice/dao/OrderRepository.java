package com.plenilune.practice.dao;

import com.plenilune.practice.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}

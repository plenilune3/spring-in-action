package com.plenilune.tacodata;

import com.plenilune.tacodomain.User;
import org.springframework.data.repository.CrudRepository;
import com.plenilune.tacodomain.Order;

import java.awt.print.Pageable;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}

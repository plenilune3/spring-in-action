package com.plenilune.practice.controller;

import com.plenilune.practice.dao.OrderRepository;
import com.plenilune.practice.domain.Order;
import com.plenilune.practice.domain.User;
import com.plenilune.practice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal User user,
                            @ModelAttribute Order order) {

        order.fillUpTheForm(user);

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {

        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);
        orderService.saveOrder(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}

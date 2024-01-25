package com.ecommerce.controller;

import com.ecommerce.entity.OrderInput;
import com.ecommerce.service.OrderDetailService;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PreAuthorize("hasRole('User')")
    @PostMapping("/placeOrder/{isCartCheckout}")
    public void placeOrder(@PathVariable(name = "isCartCheckout") boolean isSingleProductCheckout,
            @RequestBody OrderInput orderInput) {
        orderDetailService.placeOrder(orderInput, isSingleProductCheckout);
    }
}

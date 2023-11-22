package com.hdfc.Grocery.App.controller;


import com.hdfc.Grocery.App.entity.Order;
import com.hdfc.Grocery.App.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId).orElse(null);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PostMapping("/create-multiple")
    public void createMultipleOrders(@RequestBody List<Order> orders) {
        orderService.saveAll(orders);
    }

    @PutMapping("/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(orderId, updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @DeleteMapping("/delete-all")
    public void deleteAllOrders() {
        orderService.deleteAllOrders();
    }


    // Other CRUD operations for orders
}


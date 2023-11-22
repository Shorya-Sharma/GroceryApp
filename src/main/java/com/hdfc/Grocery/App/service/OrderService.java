package com.hdfc.Grocery.App.service;

import com.hdfc.Grocery.App.dao.OrderRepository;
import com.hdfc.Grocery.App.dao.UserRepository;
import com.hdfc.Grocery.App.dao.WalletRepository;
import com.hdfc.Grocery.App.entity.Order;
import com.hdfc.Grocery.App.entity.User;
import com.hdfc.Grocery.App.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, Order updatedOrder) {
        Optional<Order> existingOrderOptional = orderRepository.findById(orderId);

        if (existingOrderOptional.isPresent()) {
            updatedOrder.setId(orderId);
            return orderRepository.save(updatedOrder);
        } else {
            // Handle order not found
            return null;
        }
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public void saveAll(List<Order> orders) {

        orderRepository.saveAll(orders);

        BigDecimal totalValue = BigDecimal.ZERO;
        for (Order order : orders) {
            totalValue = totalValue.add(order.getTotalAmount());
        }


        if (!orders.isEmpty()) {

            User user = userRepository.findById(orders.get(0).getUser().getId()).orElse(new User());

            BigDecimal historicalSpent = user.getHistoricalTotalSpent();
            BigDecimal walletAmount = user.getWalletAmount();
            BigDecimal updatedTotalSpent = historicalSpent.add(totalValue).subtract(walletAmount);

            user.setHistoricalTotalSpent(updatedTotalSpent);
            user.setWalletAmount(BigDecimal.valueOf(0));

            Wallet wallet = walletRepository.findByTotalValue(updatedTotalSpent);

            BigDecimal discountFraction = BigDecimal.valueOf(wallet.getDiscountFraction()/100);
            BigDecimal discount = updatedTotalSpent.multiply(discountFraction);
            user.setWalletAmount(discount);

            userRepository.save(user);
        }

    }


    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }


}

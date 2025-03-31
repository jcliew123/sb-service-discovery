package jcliew.order_service.controller;

import jcliew.order_service.communication.UserServiceClient;
import jcliew.order_service.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    private final UserServiceClient userServiceClient;

    public OrderController(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getOrderWithUser(@PathVariable Integer userId){
        User user = userServiceClient.getUser(userId);
        return ResponseEntity.ok(Map.of(
                "user", user,
                "orders", List.of("Order1", "Order2")
        ));
    }

}

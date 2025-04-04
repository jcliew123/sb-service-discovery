package jcliew.order_service.communication;

import jcliew.order_service.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserServiceClient {
    @GetMapping("/v1/users/{id}")
    User getUser(@PathVariable Integer id);
}

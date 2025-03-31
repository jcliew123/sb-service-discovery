package jcliew.user_service.controller;

import jcliew.user_service.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        User jc = new User(id, "JC", "jctest@gmail.com");
        return new ResponseEntity<>(jc, HttpStatus.OK);
    }
}

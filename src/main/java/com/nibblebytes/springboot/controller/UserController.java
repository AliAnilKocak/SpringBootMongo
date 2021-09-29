package com.nibblebytes.springboot.controller;

import com.nibblebytes.springboot.entity.User;
import com.nibblebytes.springboot.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init(){
        User user = new User();
        user.setName("Ali Anil");
        user.setSurname("Koçak");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> all(UserController user){
        return ResponseEntity.ok(userRepository.findAll());
    }



}

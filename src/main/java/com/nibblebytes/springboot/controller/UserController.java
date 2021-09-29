package com.nibblebytes.springboot.controller;

import com.nibblebytes.springboot.entity.User;
import com.nibblebytes.springboot.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.List;

@Api(value = "User Rest Controller", description = "REST API for User")
@RequestMapping("/api/user")
@EnableSwagger2
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

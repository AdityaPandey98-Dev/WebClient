package com.abcd.userservice.controller;

import com.abcd.userservice.model.User;
import com.abcd.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){

        return userService.getUser(id);

    }

}
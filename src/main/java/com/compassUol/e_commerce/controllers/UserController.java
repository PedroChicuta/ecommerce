package com.compassUol.e_commerce.controllers;

import com.compassUol.e_commerce.dto.UserDTO;
import com.compassUol.e_commerce.entities.User;
import com.compassUol.e_commerce.service.SaleService;
import com.compassUol.e_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> findAllOrders(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }
}

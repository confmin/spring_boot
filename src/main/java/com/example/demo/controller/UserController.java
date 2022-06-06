package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.in.UserIn;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name ="/api/user" )
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {
    @Autowired
    private UserService userService ;

    @GetMapping
    public ResponseEntity<List<UserDto>> get()
    {
        return new ResponseEntity<List<UserDto>>(userService.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody UserIn userIn)
    {
        return new ResponseEntity<User>(userService.add(userIn),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id)
    {
        return new ResponseEntity<User>(userService.delete(id),HttpStatus.OK);
    }
}

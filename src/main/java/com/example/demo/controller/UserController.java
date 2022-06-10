package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.in.UserIn;
import com.example.demo.respon.Respon;
import com.example.demo.respon.ResponPage;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user" )
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService ;

    @GetMapping
    public ResponseEntity<List<UserDto>> get()
    {
        return new ResponseEntity<List<UserDto>>(userService.get(), HttpStatus.OK);
    }
    @PostMapping("/{limit}")
    public ResponseEntity<?> add(@RequestBody UserIn userIn, @PathVariable Integer limit)
    {
        return new ResponseEntity<ResponPage>(userService.add(userIn,limit),HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id , @RequestBody UserIn userIn)
    {
        return new ResponseEntity<User>(userService.update(id,userIn),HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable Integer id)
    {
        return new ResponseEntity<Map<String,Object>>(userService.delete(id),HttpStatus.OK);
    }
    @GetMapping("/best")
    public ResponseEntity<List<User>> getbest()
    {
        return  new ResponseEntity<List<User>>(userService.getbest(),HttpStatus.OK);
    }
    @GetMapping("/page")
    public  ResponseEntity<?> getpage(
            @RequestParam Integer activePage
            , @RequestParam Integer limit)
    {
        return new ResponseEntity<ResponPage>(userService.getpage(activePage, limit),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> getuser(@PathVariable Integer id)
    {
        return  new ResponseEntity<User>(userService.getuser(id),HttpStatus.OK);
    }

}

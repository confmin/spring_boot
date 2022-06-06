package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.in.UserIn;

import java.util.List;

public interface UserService {
    List<UserDto> get();
    User add(UserIn userIn);
    User update(Integer id , UserIn userIn);
    User delete(Integer id);
}

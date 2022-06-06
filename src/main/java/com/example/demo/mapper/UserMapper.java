package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.in.UserIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserMapper {
    public static UserDto map(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setStatus(user.getStatus());

        return userDto ;
    }
    public static User map(UserIn userIn)
    {
        User user = new User();
        user.setId(userIn.getId());
        user.setName(userIn.getName());
        user.setStatus(userIn.getStatus());
        return user ;
    }


}

package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import com.example.demo.in.UserIn;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private StatusRepository statusRepository;
    @Override
    public List<UserDto> get() {
        List<User> listdata = new ArrayList<>();
        listdata = userRepository.findAll();
        List<UserDto> listdto = listdata.stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
        return  listdto ;
    }

    @Override
    public User add(UserIn userIn) {
        User user = UserMapper.map(userIn);
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, UserIn userIn) {
        User user = userRepository.getById(id);
        userIn.setId(id);
        Status status = user.getStatus();
        if (userIn.getId_status() != null){
            status = statusRepository.findStatusById(userIn.getId_status());
        }
        if (userIn.getId_status() != null){
            status = userIn.getStatus();
        }
        user = UserMapper.map(userIn);
        user.setStatus(status);
        User user1 = user;
        return userRepository.save(user1);
    }

    @Override
    public User delete(Integer id) {
        User user  = userRepository.findUserById(id);
        user.setStatus(null);
        try
        {

            userRepository.delete(user);
            return  user ;
        }
        catch (Exception e)
        {
            e.getMessage() ;
        }
        return user  ;
    }
}

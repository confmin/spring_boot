package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.in.UserIn;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private StatusRepository statusRepository;
    @Override
    public List<UserDto> get() {

        List<User>  listdata = userRepository.getUser();
        List<UserDto> listdto = listdata.stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
        return  listdto ;
    }

    @Override
    public User add(UserIn userIn)  {
        User user = UserMapper.map(userIn);
        user.setStatus(statusRepository.getById(userIn.getStatus()));
        user.setTime(Time.valueOf(LocalTime.now()));
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, UserIn userIn) {
       User user = userRepository.findUserById(id);
       user.setId(id);
       Status status = user.getStatus();
       user.setName(userIn.getName());
       user.setStatus(statusRepository.getById(userIn.getStatus()));
       user.setTime(Time.valueOf(LocalTime.now()));
       return  userRepository.save(user);

    }


    @Override
    public Map<String,Object> delete(Integer id) {
        User user = userRepository.findUserById(id);
            userRepository.delete(user);
        Map<String, Object> repon = new HashMap<>();
        repon.put("result", "ok");
            return  repon ;
    }

    @Override
    public List<User> getbest() {
        List<User> get = userRepository.getBest();
        return  get ;

    }

    @Override
    public List<User> get_page(Pageable pageable) {
        Page<User>
    }
}

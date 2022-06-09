package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.in.UserIn;
import com.example.demo.respon.Respon;
import com.example.demo.respon.ResponPage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    List<UserDto> get();
    User add(UserIn userIn);
    User update(Integer id , UserIn userIn);
    Map<String,Object> delete(Integer id);
    List<User> getbest();
    ResponPage getpage(Integer pageNo , Integer pageSize) ;
    User getuser(Integer id);





}

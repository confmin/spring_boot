package com.example.demo.service;

import com.example.demo.dto.StatusDto;
import com.example.demo.entity.Status;
import com.example.demo.in.StatusIn;
import com.example.demo.mapper.StatusMapper;
import com.example.demo.repository.StatusRepository;
import com.example.demo.respon.Respon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component

public class StatusServiceImp implements StatusService{
@Autowired
    private StatusRepository statusRepository;

    @Override
    public List<StatusDto> get() {

//        Set<Status> listdata = new HashSet<>();
        List<Status> listdata = statusRepository.getOrderByUutien();
        System.out.println("listdata"+listdata);
        List<StatusDto> listdto =  listdata.stream()
                .map(StatusMapper::map)
                .collect(Collectors.toList());
        System.out.println(listdto+"aa");
        return listdto ;
    }

    @Override
    public Respon add(StatusIn statusIn) {
        Status status = StatusMapper.map(statusIn);
       
        Boolean checkName = statusRepository.getName(statusIn.getStatus()).isPresent();
        Boolean checkLevel = statusRepository.getLevel(statusIn.getLevel()).isPresent();
        System.out.println("cc"+checkName);
        if (checkName){
         return new Respon(false," Status da ton tai ","");
        }
        else if (checkLevel)
        {
            return new Respon(false," Level da ton tai ","");
        }
        else {
            statusRepository.save(status);
        }
        return new Respon(true,"Add thanh cong",status) ;
        }
    @Override
    public Respon update(Integer id, StatusIn statusIn) {
        Boolean checkName = statusRepository.getName(statusIn.getStatus()).isPresent();
        Boolean checkLevel = statusRepository.getLevel(statusIn.getLevel()).isPresent();
        Status status = statusRepository.getById(id) ;
        status.setId(id);
        if (checkName && checkLevel){
            return new Respon(false," cc ","");
        }
        else {
            status.setStatus(statusIn.getStatus());
            status.setLevel(statusIn.getLevel());
            statusRepository.save(status);
        }
        return new Respon(true,"Update suss",status);
    }


}

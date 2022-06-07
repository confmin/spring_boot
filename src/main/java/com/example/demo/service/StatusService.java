package com.example.demo.service;

import com.example.demo.dto.StatusDto;
import com.example.demo.in.StatusIn;
import com.example.demo.respon.Respon;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface StatusService {
    List<StatusDto> get() ;
    Respon add(StatusIn statusIn);
    Respon update(Integer id , StatusIn statusIn) ;

}

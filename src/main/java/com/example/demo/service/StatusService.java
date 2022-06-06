package com.example.demo.service;

import com.example.demo.dto.StatusDto;
import com.example.demo.entity.Status;
import com.example.demo.in.StatusIn;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface StatusService {
    Set<StatusDto> get() ;
    Status add(StatusIn statusIn);

}

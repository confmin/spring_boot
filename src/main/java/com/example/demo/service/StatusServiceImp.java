package com.example.demo.service;

import com.example.demo.dto.StatusDto;
import com.example.demo.entity.Status;
import com.example.demo.in.StatusIn;
import com.example.demo.mapper.StatusMapper;
import com.example.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component

public class StatusServiceImp implements StatusService{
@Autowired
    private StatusRepository statusRepository;

    @Override
    public Set<StatusDto> get() {
        Set<Status> listdata = new HashSet<>();
        listdata = (Set<Status>) statusRepository.getOrderByUutien();
        Set<StatusDto> listdto = (Set<StatusDto>) listdata.stream()
                .map(StatusMapper::map)
                .collect(Collectors.toList());
        return  listdto ;
    }

    @Override
    public Status add(StatusIn statusIn) {
        Status status = StatusMapper.map(statusIn);
        return statusRepository.save(status);
    }
}

package com.example.demo.mapper;

import com.example.demo.dto.StatusDto;
import com.example.demo.entity.Status;
import com.example.demo.in.StatusIn;
import com.example.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StatusMapper {
    @Autowired

    public  static StatusDto map(Status status)
    {
        StatusDto statusDto = new StatusDto();
        statusDto.setId(status.getId());
        statusDto.setStatus(status.getStatus());
        statusDto.setLevel(status.getLevel());
        return statusDto ;
    }
    public static Status map(StatusIn statusIn)
    {
        StatusMapper cc = new StatusMapper();

        Status  status = new Status();

        if (statusIn.getId() != null){
            status.setId(statusIn.getId());
        }
        status.setStatus(statusIn.getStatus());

            status.setLevel(statusIn.getLevel());

        return status ;
    }
}

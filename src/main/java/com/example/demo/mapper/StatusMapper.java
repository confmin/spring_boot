package com.example.demo.mapper;

import com.example.demo.dto.StatusDto;
import com.example.demo.entity.Status;
import com.example.demo.in.StatusIn;

public class StatusMapper {
    public  static StatusDto map(Status status)
    {
        StatusDto statusDto = new StatusDto();
        statusDto.setId(status.getId());
        statusDto.setName(status.getName());
        status.setUutien(status.getUutien());
        return statusDto ;
    }
    public static Status map(StatusIn statusIn)
    {
        Status  status = new Status();
        status.setId(statusIn.getId());
        status.setName(statusIn.getName());
        status.setUutien(statusIn.getUutien());
        return status ;
    }
}

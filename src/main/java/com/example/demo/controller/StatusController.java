package com.example.demo.controller;

import com.example.demo.dto.StatusDto;
import com.example.demo.entity.Status;
import com.example.demo.in.StatusIn;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(name = "/api/status")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class StatusController {
    @Autowired
    private StatusService statusService ;
    @GetMapping
    public ResponseEntity<Set<StatusDto>> get()
    {

        return new ResponseEntity(statusService.get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody StatusIn statusIn)
    {
        return new ResponseEntity<Status>(statusService.add(statusIn),HttpStatus.OK) ;
    }
}

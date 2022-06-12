package com.example.demo.controller;

import com.example.demo.dto.StatusDto;
import com.example.demo.entity.Status;
import com.example.demo.in.StatusIn;
import com.example.demo.respon.Respon;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/status")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class StatusController {
    @Autowired
    private StatusService statusService ;
    @GetMapping
    public ResponseEntity<List<StatusDto>> get()
    {
        return new ResponseEntity(statusService.get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody StatusIn statusIn)
    {
        return new ResponseEntity<Respon>(statusService.add(statusIn),HttpStatus.OK) ;
    }
    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@PathVariable Integer id , @RequestBody StatusIn statusIn)
    {
        return new ResponseEntity<Respon>(statusService.update(id , statusIn),HttpStatus.OK) ;
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateall(@RequestBody StatusIn statusIn)
    {
        return new ResponseEntity<Respon>(statusService.updateall(statusIn),HttpStatus.OK);
    }

}

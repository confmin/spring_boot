package com.example.demo.dto;

import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto {
    private Integer id ;
    private String name ;
    private Set<User> users ;
}

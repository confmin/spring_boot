package com.example.demo.in;

import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserIn {
    private Integer id ;
    private  String name ;
    private Integer id_status ;
    private Integer uutien ;
   private Status status   ;
}

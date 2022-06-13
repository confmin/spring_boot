package com.example.demo.in;

import com.example.demo.entity.User;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StatusIn {
    private Integer id ;
    private String status ;
    private Integer level ;
 private List<StatusIn> statusall ;

}

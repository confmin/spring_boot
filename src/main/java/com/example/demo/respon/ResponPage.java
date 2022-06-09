package com.example.demo.respon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponPage {
    Boolean status ;
    String message ;
    Integer totalPage ;
    Object data ;

    @Override
    public String toString() {
        return "{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }
}

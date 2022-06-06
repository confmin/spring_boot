package com.example.demo.repository;

import com.example.demo.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status,Integer> {
    Status findStatusById(Integer id);
    @Query(value = "SELECT * from Status order by uutien",nativeQuery = true)
        List<Status> getOrderByUutien() ;
}

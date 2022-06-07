package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id) ;
    User getById(Integer id);
    @Query(value = "SELECT * from users join statuses on statuses.id = users.id_status order by statuses.level , users.time  ",nativeQuery = true)
    List<User> getUser();
    @Query(value = "SELECT * from users join statuses on statuses.id = users.id_status order by statuses.level , users.time limit 1",nativeQuery = true)
    List<User> getBest();
}

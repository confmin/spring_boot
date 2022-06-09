package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User getById(Integer id);
    @Query(value = "SELECT * from users join statuses on statuses.id = users.id_status order by statuses.level , users.time  ",nativeQuery = true)
    List<User> getUser();
    @Query(value = "SELECT * from users join statuses on statuses.id = users.id_status order by statuses.level , users.time limit 1",nativeQuery = true)
    List<User> getBest();
    @Query(value = "SELECT * from users join statuses on statuses.id = users.id_status order by statuses.level , users.time  ",nativeQuery = true)
    Page<User> getPage(Pageable pageable);
    @Query(value ="SELECT * from users join statuses on statuses.id = users.id_status where users.id_status=?1",nativeQuery = true)
    Optional<User> getIdUser(Integer id );

}

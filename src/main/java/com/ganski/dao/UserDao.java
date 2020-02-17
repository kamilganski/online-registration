package com.ganski.dao;

import com.ganski.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    List<User> findAll();

    User findByIdentifier(String identifier);
}

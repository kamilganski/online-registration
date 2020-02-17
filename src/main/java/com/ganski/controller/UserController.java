package com.ganski.controller;

import com.ganski.dao.UserDao;
import com.ganski.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userDao.findById(id).get();
    }

    @GetMapping("/users/{identifier}")
    public User getUserByLogin(@PathVariable String identifier) {
        return userDao.findAllByIdentifier(identifier);
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userDao.save(user);
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        User userToUpdate = getUserById(id);

        if (!user.getName().isEmpty()) {
            userToUpdate.setName(user.getName());
        }
        if (!user.getSurname().isEmpty()) {
            userToUpdate.setSurname(user.getSurname());
        }
        if (!user.getEmail().isEmpty()) {
            userToUpdate.setEmail(user.getEmail());
        }
        if (!user.getPhone().isEmpty()) {
            userToUpdate.setPhone(user.getPhone());
        }

        return userDao.save(userToUpdate);
    }

    @DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable int id) {
        userDao.deleteById(id);
        return true;
    }
}

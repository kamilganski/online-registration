package com.ganski.controller;

import com.ganski.dao.UserDao;
import com.ganski.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userDao.findById(id).get();
    }

    @RequestMapping(value = "/users/{identifier}", method = RequestMethod.GET)
    public User getUserByLogin(@PathVariable String identifier) {
        return userDao.findAllByIdentifier(identifier);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userDao.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
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

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) {
        userDao.deleteById(id);
        return true;
    }
}

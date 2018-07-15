package com.maksim.model.dao;

import com.maksim.model.domain.User;

import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public interface UserDao {
    boolean addUser(User user);
    boolean updateUser(User user);

    void removeUser(int id);

    User findUserByLogin(String UserName);

    List<User> findAllUsers();

    User findUserById(int userId);
    User checkLoginAndPassword(String login, String password);
}

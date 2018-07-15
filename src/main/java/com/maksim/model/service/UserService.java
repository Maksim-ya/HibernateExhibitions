package com.maksim.model.service;

import com.maksim.controller.manager.Logs;
import com.maksim.model.dao.UserDao;
import com.maksim.model.domain.User;
import com.maksim.model.impl.DaoFactoryImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class);
    private static final UserDao userDao = DaoFactoryImpl.getInstance().getUserDao();
    private static final UserService USER_SERVICE = new UserService();

    private UserService() {}

    public static UserService getService() {
        return USER_SERVICE;
    }

    public static String encryptPassword(String st) {
        String md5Hex = DigestUtils.md5Hex(st);
        return md5Hex;
    }


    public boolean addUser(User user) {
        logger.info(Logs.USER_REGISTER);
        user.setPassword(encryptPassword(user.getPassword()));
        return userDao.addUser(user);
    }

    public User checkLoginAndPassword(String login, String password) {
        return  userDao.checkLoginAndPassword(login,encryptPassword(password));
    }
}

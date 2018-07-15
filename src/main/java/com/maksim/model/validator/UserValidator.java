package com.maksim.model.validator;

import com.maksim.model.domain.User;
import com.maksim.model.impl.DaoFactoryImpl;

public class UserValidator {
    public static boolean checkLogin(String login) {
        User user = DaoFactoryImpl.getInstance().getUserDao().findUserByLogin(login);
        if (user!=null) {
            return user.getLogin().equalsIgnoreCase(login);
        } return false;
    }

    public static boolean checkPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public static boolean checkEmail(String email) {
        return email.matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[a-zA-Z]+[a-zA-Z0-9]?[\\.a-zA-Z]+$");
    }
}

package com.maksim.controller.comand.redirect;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.UserSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        return  UserSession.loadUserDataToSession( request);
    }
}

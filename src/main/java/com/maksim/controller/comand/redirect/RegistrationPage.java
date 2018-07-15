package com.maksim.controller.comand.redirect;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       return  ConfigurationManager.getInstance().getPage(ConfigurationManager.REGISTRATION_PAGE_PATH);
    }
}

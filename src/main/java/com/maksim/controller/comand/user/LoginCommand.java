package com.maksim.controller.comand.user;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.model.domain.User;
import com.maksim.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginCommand implements Command {

    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String login = request.getParameter(PARAM_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);

        User user = UserService.getService().checkLoginAndPassword(login,password);

        if (user != null) {
            HttpSession se = request.getSession();
            se.setAttribute(PARAM_USER, user);
            se.setAttribute(PARAM_USER_NAME, user.getFullName());
           page= UserSession.loadUserDataToSession( request);
        } else {
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.LOGIN_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);
        }
        return page;
    }
}


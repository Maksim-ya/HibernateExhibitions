package com.maksim.controller.comand.user;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.model.domain.User;
import com.maksim.model.service.UserService;
import com.maksim.model.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 03/04/2018.
 */
public class RegistrationCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_CONFIRM_PASSWORD = "confirmPassword";
    private static final String PARAM_NAME_FULL_NAME = "fullName";
    private static final String PARAM_NAME_EMAIL = "email";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String confirmPassword = request.getParameter(PARAM_NAME_CONFIRM_PASSWORD);
        String fullName = request.getParameter(PARAM_NAME_FULL_NAME);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        User user = new User();

        if(login.equals("")||password.equals("")||confirmPassword.equals("")||fullName.equals("")||email.equals("")){
            request.setAttribute("requiredFieldMessage", MessageManager.getInstance().getMessage(MessageManager.REQUIRED_FIELD_MESSAGE));
            return ConfigurationManager.getInstance().getPage(ConfigurationManager.REGISTRATION_PAGE_PATH);
        }
        if (UserValidator.checkLogin(login)) {
            request.setAttribute("loginNotUniqueErrorMessage", MessageManager.getInstance().getMessage(MessageManager.LOGIN_NOT_UNIQUE_MESSAGE));
            return ConfigurationManager.getInstance().getPage(ConfigurationManager.REGISTRATION_PAGE_PATH);
        } if (!UserValidator.checkPassword(password, confirmPassword)) {
            request.setAttribute("passwordsDoNotMatchErrorMessage", MessageManager.getInstance().getMessage(MessageManager.PASSWORDS_DO_NOT_MATCH_ERROR_MESSAGE));
            return ConfigurationManager.getInstance().getPage(ConfigurationManager.REGISTRATION_PAGE_PATH);
        }if (!UserValidator.checkEmail(email)) {
            request.setAttribute("invalidEmailErrorMessage", MessageManager.getInstance().getMessage(MessageManager.PASSWORDS_DO_NOT_MATCH_ERROR_MESSAGE));
            return ConfigurationManager.getInstance().getPage(ConfigurationManager.REGISTRATION_PAGE_PATH);
        }
        else {
            user.setLogin(login);
            user.setPassword(password);
            user.setFullName(fullName);
            user.setEmail(email);
        }

        if (UserService.getService().addUser(user)) {

            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);
            request.setAttribute("registrationMessage", MessageManager.getInstance().getMessage(MessageManager.SUCCESS_REGISTRATION_MESSAGE));

        } else {
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.SERVER_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}

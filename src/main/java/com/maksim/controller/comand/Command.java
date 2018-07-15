package com.maksim.controller.comand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Максим on 03/May/18.
 */
public interface Command {
    String PARAM_USER = "user";
    String PARAM_EXPOSITION = "exposition";
    String LIST_OF_USER_EXPOSITIONS = "listOfUserExpositions";
    String PARAM_USER_NAME ="userName" ;


    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

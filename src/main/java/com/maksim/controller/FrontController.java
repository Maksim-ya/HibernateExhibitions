package com.maksim.controller;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.Logs;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Максим on 03/May/18.
 */
public class FrontController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(FrontController.class);

    RequestHelper requestHelper = RequestHelper.getInstance();

    public FrontController() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page ;
        try {
            Command command = requestHelper.getCommand(request);

            page = command.execute(request, response);

        }catch (Exception e) {
            logger.error(e.getMessage());
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        logger.info(Logs.REDIRECT_TO + page);
        dispatcher.forward(request, response);
    }
}

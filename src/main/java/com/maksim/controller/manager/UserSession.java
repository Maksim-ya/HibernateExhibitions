package com.maksim.controller.manager;

import com.maksim.model.dao.TicketDao;
import com.maksim.model.domain.Exposition;
import com.maksim.model.domain.Ticket;
import com.maksim.model.domain.User;
import com.maksim.model.impl.DaoFactoryImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by Максим on 03/May/18.
 */
public class UserSession {
    private static final Logger logger = Logger.getLogger(UserSession.class);

    private static final String PARAM_USER = "user";
    private static final String PARAM_TICKETS = "listOfTickets";


    public static String loadUserDataToSession(HttpServletRequest request) {
        logger.info(Logs.LOAD_USER_TO_SESSION);
        String page;
        HttpSession se = request.getSession(true);

        User user = (User) se.getAttribute(PARAM_USER);
        if (user == null) {
            return ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);
        } else {
            if (se.getAttribute("listOfUserExpositions") != null) {
                List<Exposition> list = (List<Exposition>) se.getAttribute("listOfUserExpositions");
                for (int i = 0; i <list.size() ; i++) {
                    System.out.println(list.get(i));
                }
                page = ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);
            } else {
                TicketDao ticketDao = DaoFactoryImpl.getInstance().getTicketDao();
                List<Ticket> list = ticketDao.findTicketsByUserByEventDate(user.getUserId());

                request.setAttribute(PARAM_TICKETS, list);

                page = ConfigurationManager.getInstance().getPage(ConfigurationManager.MAIN_PAGE_PATH);
            }
        }
        return page;
    }
}

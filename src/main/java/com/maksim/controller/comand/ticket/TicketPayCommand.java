package com.maksim.controller.comand.ticket;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.model.domain.Exposition;
import com.maksim.model.domain.Ticket;
import com.maksim.model.domain.User;
import com.maksim.model.impl.DaoFactoryImpl;
import com.maksim.model.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class TicketPayCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        HttpSession se = request.getSession(true);
        User user = (User) se.getAttribute(PARAM_USER);
        List<Exposition> listOfUserExpositions = (List<Exposition>) se.getAttribute("listOfUserExpositions");
        BigDecimal totalPrice = new BigDecimal("0.0");

        List<Ticket> ticketList = new ArrayList<Ticket>();
        for (int i = 0; i < listOfUserExpositions.size(); i++) {
            Ticket ticket = new Ticket();
            ticket.setUser(user);
            ticket.setExposition(listOfUserExpositions.get(i));
            int expositionId = listOfUserExpositions.get(i).getExpositionId();
            int numberOfPersons = Integer.parseInt(request.getParameter("numberOfPersons" + expositionId));
            if (numberOfPersons > 0) {
                ticket.setNumberOfPersons(numberOfPersons);
                ticket.setEventDate(LocalDate.parse(request.getParameter("eventDate" + expositionId)));
                ticketList.add(ticket);
                totalPrice = totalPrice.add(DaoFactoryImpl.getInstance().getExpositionDao()
                        .findById(listOfUserExpositions.get(i).getExpositionId())
                        .getPrice().multiply(BigDecimal.valueOf(ticket.getNumberOfPersons())));
            }
            else {
                request.setAttribute("numberOfPersonsErrorMessage", MessageManager.getInstance().getMessage(MessageManager.NUMBER_OF_PERSONS_ERROR_MESSAGE));
                return ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);}
        }


        if (user.getAccount().compareTo(totalPrice) >= 0) {
            try {
                TicketService.getService().ticketTransaction(user, ticketList, totalPrice);
                se.setAttribute(LIST_OF_USER_EXPOSITIONS, null);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.SERVER_ERROR_MESSAGE));
                 ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
            }
            page = UserSession.loadUserDataToSession(request);
        } else {
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.NO_MONEY_PAGE_PATH);
        }

        return page;
    }
}

package com.maksim.controller.comand;

import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.model.dao.UserDao;
import com.maksim.model.domain.User;
import com.maksim.model.impl.DaoFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

public class ReplenishAccount implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        HttpSession se = request.getSession(true);
        User user = (User) se.getAttribute(PARAM_USER);
        String valueOfReplenish = request.getParameter("valueOfReplenish");
        BigDecimal sumOfReplenish = new BigDecimal(valueOfReplenish);

        UserDao userDao = DaoFactoryImpl.getInstance().getUserDao();
        user.setAccount(user.getAccount().add(sumOfReplenish));

        if (userDao.updateUser(user)) {

            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);
            request.setAttribute("replenishMessage", MessageManager.getInstance().getMessage(MessageManager.SUCCESS_REPLENISH_MESSAGE));

        } else {
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.SERVER_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;

    }
}

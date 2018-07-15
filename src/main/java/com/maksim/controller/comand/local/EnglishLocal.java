package com.maksim.controller.comand.local;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

/**
 * Created by Максим on 09/May/18.
 */
public class EnglishLocal implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageManager.setLocale(MessageManager.ENGLISH);
        Config.set(request.getSession(), Config.FMT_LOCALE, MessageManager.ENGLISH);
        String page = ConfigurationManager.getInstance().getPage(ConfigurationManager.INDEX_PAGE_PATH);
        return page;
    }
}

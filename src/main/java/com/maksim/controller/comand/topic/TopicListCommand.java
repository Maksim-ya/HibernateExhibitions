package com.maksim.controller.comand.topic;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.model.dao.ExpositionDao;
import com.maksim.model.impl.DaoFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TopicListCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        ExpositionDao expositionDao = DaoFactoryImpl.getInstance().getExpositionDao();
        List<String> list = expositionDao.findAllTopics();

        request.setAttribute("listOfTopics", list);

        page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ALL_TOPICS_PAGE_PATH);

        return page;
    }
}

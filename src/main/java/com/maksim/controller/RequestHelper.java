package com.maksim.controller;

import com.maksim.controller.comand.BasketCommand;
import com.maksim.controller.comand.Command;
import com.maksim.controller.comand.NoCommand;
import com.maksim.controller.comand.ReplenishAccount;
import com.maksim.controller.comand.exposition.ExpositionListCommand;
import com.maksim.controller.comand.local.EnglishLocal;
import com.maksim.controller.comand.local.RussianLocal;
import com.maksim.controller.comand.redirect.LoginPage;
import com.maksim.controller.comand.redirect.RegistrationPage;
import com.maksim.controller.comand.redirect.ReplenishAccountPage;
import com.maksim.controller.comand.ticket.TicketPayCommand;
import com.maksim.controller.comand.topic.TopicListCommand;
import com.maksim.controller.comand.user.LoginCommand;
import com.maksim.controller.comand.user.LogoutCommand;
import com.maksim.controller.comand.user.RegistrationCommand;
import com.maksim.controller.manager.Logs;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Максим on 03/May/18.
 */
public class RequestHelper {

    private static final Logger logger = Logger.getLogger(RequestHelper.class);

    private static RequestHelper instance = null;

    public static RequestHelper getInstance() {

        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }

    HashMap<String, Command> commands = new HashMap<String, Command>();

    private RequestHelper() {
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("localRu", new RussianLocal());
        commands.put("localEn", new EnglishLocal());
        commands.put("registrationPage", new RegistrationPage());
        commands.put("loginPage", new LoginPage());
        commands.put("replenishPage", new ReplenishAccountPage());
        commands.put("replenish", new ReplenishAccount());
        commands.put("allExpositions", new ExpositionListCommand());
        commands.put("allTopics", new TopicListCommand());
        commands.put("basket", new BasketCommand());
        commands.put("payment", new TicketPayCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        Command command = commands.get(action);
        logger.info(Logs.CALLED_COMMAND+command.getClass().getName());
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }


}


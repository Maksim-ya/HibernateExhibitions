package com.maksim.model.impl;

import com.maksim.model.dao.TicketDao;
import com.maksim.model.domain.Exposition;
import com.maksim.model.domain.Payment;
import com.maksim.model.domain.Ticket;
import com.maksim.model.domain.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class TicketDaoImpl implements TicketDao {
    private static final Logger logger = Logger.getLogger(TicketDaoImpl.class);

    private final static TicketDaoImpl ticketDaoImpl = new TicketDaoImpl();

    private TicketDaoImpl() {
    }
    static TicketDaoImpl getInstance() {
        return ticketDaoImpl;
    }

    @Override
    public List<Ticket> findTicketsByUserByEventDate(int userId) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = DBConnection.getConnection();
//            statement = connection.prepareStatement(
//                    "SELECT * FROM tickets WHERE userId = ? ORDER BY eventDate");
//            statement.setInt(1, userId);
//            resultSet = statement.executeQuery();
//            List<Ticket> list =  resultToList(resultSet);
//            return list;
//        } catch (SQLException e) {
//            logger.error(e.getMessage());
//        } finally {
//            DBConnection.close(connection, statement, resultSet);
//        }
        return null;
    }
    private List<Ticket> resultToList(ResultSet resultSet) throws SQLException {
        List<Ticket> list = new ArrayList<Ticket>();
        while (resultSet.next()) {
            Ticket ticket= createTicketFromResult(resultSet);
            list.add(ticket);
        }
        return list;
    }

    private Ticket createTicketFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int ticketId = resultSet.getInt(1);
        int userId = resultSet.getInt(2);
        int paymentId = resultSet.getInt(3);
        int expositionId = resultSet.getInt(4);
        int numberOfPersons = resultSet.getInt(5);
        LocalDate eventDate = LocalDate.parse(resultSet.getString(6));
        User user = UserDaoImpl.getInstance().findUserById(userId);
        Payment payment = PaymentDaoImpl.getInstance().findPaymentById(paymentId);
        Exposition exposition =  ExpositionDaoImpl.getInstance().findById(expositionId);
        return new Ticket(ticketId, user, payment,exposition,numberOfPersons,eventDate );
    }

    @Override
    public boolean addTicket(Ticket ticket) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection =  DBConnection.getConnection();
//            preparedStatement = connection.prepareStatement(
//                    "INSERT INTO tickets (userId,paymentId, expositionId,numberOfPersons, eventDate) VALUES (?,?,?,?,?)");
//            preparedStatement.setInt(1, ticket.getUser().getUserId());
//            preparedStatement.setInt(2, ticket.getPayment().getPaymentId());
//            preparedStatement.setInt(3, ticket.getExposition().getExpositionId());
//            preparedStatement.setInt(4, ticket.getNumberOfPersons());
//            preparedStatement.setString(5, ticket.getEventDate().toString());
//            preparedStatement.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            logger.error(e.getMessage());
//        } finally {
//            DBConnection.close(connection, preparedStatement);
//        }
        return false;
    }
}

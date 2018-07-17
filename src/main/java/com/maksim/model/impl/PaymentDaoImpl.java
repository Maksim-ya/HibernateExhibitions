package com.maksim.model.impl;

import com.maksim.model.dao.PaymentDao;
import com.maksim.model.domain.Payment;
import com.maksim.model.domain.Ticket;
import com.maksim.model.domain.User;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class PaymentDaoImpl implements PaymentDao {
    private static final Logger logger = Logger.getLogger(PaymentDaoImpl.class);

    private final static PaymentDaoImpl paymentDaoImpl= new PaymentDaoImpl();

    private PaymentDaoImpl() {
    }

    static PaymentDaoImpl getInstance() {
        return paymentDaoImpl;
    }

//    @Override
//    public boolean addPayment(User user, List<Ticket> ticketList, BigDecimal totalPrice) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        Payment payment = new Payment();
//        int userId;
//        try {
//            connection = DBConnection.getConnection();
//            preparedStatement = connection.prepareStatement(
//                    "INSERT INTO payments (userId, totalPrice, dateTime) VALUES (?,?,?)");
//            userId = user.getUserId();
//            preparedStatement.setInt(1, userId);
//            preparedStatement.setBigDecimal(2, totalPrice);
//            Date date = new Date();
//            Timestamp dateTime = new Timestamp(date.getTime());
//            dateTime.setNanos(0);
//            preparedStatement.setTimestamp(3, dateTime);
//            preparedStatement.executeUpdate();
//
//
//            payment = new PaymentDaoImpl().findPaymentByPaymentInfo(userId, totalPrice, dateTime);// error
//
//            connection.setAutoCommit(false);
//            for (int i = 0; i < ticketList.size(); i++) {
//
//                Ticket ticket = ticketList.get(i);
//                ticket.setPayment(payment);
//
//
//                preparedStatement = connection.prepareStatement(
//                        "INSERT INTO tickets (userId,paymentId,expositionId,numberOfPersons,eventDate) VALUES (?,?,?,?,?)");
//                preparedStatement.setInt(1, ticket.getUser().getUserId());
//                preparedStatement.setInt(2, ticket.getPayment().getPaymentId());
//                preparedStatement.setInt(3, ticket.getExposition().getExpositionId());
//                preparedStatement.setInt(4, ticket.getNumberOfPersons());
//                preparedStatement.setString(5, ticket.getEventDate().toString());
//                preparedStatement.executeUpdate();
//            }
//            BigDecimal priceUpdate = user.getAccount().subtract(totalPrice);
//            user.setAccount(priceUpdate);
//            preparedStatement = connection.prepareStatement(
//                    "UPDATE USERS  SET LOGIN = ?, PASSWORD = ?, FULLNAME = ?, ADDRESS = ?, ACCOUNT= ? WHERE USERID = ? ");
//            preparedStatement.setString(1, user.getLogin());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getFullName());
//            preparedStatement.setString(4, user.getAddress());
//            preparedStatement.setBigDecimal(5, user.getAccount());
//            preparedStatement.setInt(6, user.getUserId());
//            preparedStatement.executeUpdate();
//            connection.commit();
//            return true;
//        } catch (Exception e) {
//            try {
//                connection.rollback();
//            } catch (SQLException e1) {
//                logger.error(e1.getMessage());
//            }
//            new PaymentDaoImpl().deletePayment(payment);
//            logger.error(e.getMessage());
//            return false;
//
//        } finally {
//            DBConnection.close(connection, preparedStatement);
//        }
//    }

    public Payment findPaymentByPaymentInfo(int userId, BigDecimal totalPrice, Timestamp dateTime) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = DBConnection.getConnection();
//            preparedStatement = connection.prepareStatement(
//                    "SELECT * FROM PAYMENTS WHERE USERID = ? AND TOTALPRICE=? AND DATETIME =?");
//            preparedStatement.setInt(1, userId);
//            preparedStatement.setBigDecimal(2, totalPrice);
//            preparedStatement.setTimestamp(3, dateTime);
//            resultSet = preparedStatement.executeQuery();
//            return createPaymentFromResult(resultSet);
//        } catch (SQLException e) {
//            logger.error(e.getMessage());
//
//        } finally {
//            DBConnection.close(connection, preparedStatement, resultSet);
//        }
        return null;
    }

    @Override
    public int addPayment(User user, List<Ticket> ticketList, BigDecimal totalPrice) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        int userId;
//        try {
//            connection = DBConnection.getConnection();
//            preparedStatement = connection.prepareStatement(
//                    "INSERT INTO payments (userId, totalPrice, dateTime) VALUES (?,?,?)");
//            userId = user.getUserId();
//            preparedStatement.setInt(1, userId);
//            preparedStatement.setBigDecimal(2, totalPrice);
//            Date date = new Date();
//            Timestamp dateTime = new Timestamp(date.getTime());
//            dateTime.setNanos(0);
//            preparedStatement.setTimestamp(3, dateTime);
//            preparedStatement.executeUpdate();
//            return DaoFactoryImpl.getInstance().getPaymentDao()
//                    .findPaymentByPaymentInfo(userId,totalPrice,dateTime).getPaymentId();
//        } catch (SQLException e) {
//            logger.error(e.getMessage());
//        } finally {
//            DBConnection.close(connection, preparedStatement);
//        }
        return 0;
    }

    @Override
    public Payment findPaymentById(int paymentId) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = DBConnection.getConnection();
//            preparedStatement = connection.prepareStatement(
//                    "SELECT * FROM PAYMENTS WHERE PAYMENTID = ?");
//            preparedStatement.setInt(1, paymentId);
//            resultSet = preparedStatement.executeQuery();
//            return createPaymentFromResult(resultSet);
//        } catch (SQLException e) {
//            logger.error(e.getMessage());
//        } finally {
//            DBConnection.close(connection, preparedStatement, resultSet);
//        }
        return null;
    }

    @Override
    public void deletePayment(Payment payment) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = DBConnection.getConnection();
//            preparedStatement = connection.prepareStatement(
//                    "DELETE FROM payments WHERE paymentId=?");
//            preparedStatement.setInt(1, payment.getPaymentId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            logger.error(e.getMessage());
//        } finally {
//            DBConnection.close(connection, preparedStatement);
//        }
    }
    private Payment createPaymentFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int paymentId = resultSet.getInt(1);
        int userId = resultSet.getInt(2);
        User user = UserDaoImpl.getInstance().findUserById(userId);
        BigDecimal totalPrice = resultSet.getBigDecimal(3);
        Timestamp dateTime = resultSet.getTimestamp(4);
        Payment payment = new Payment(paymentId, user, totalPrice, dateTime);
        return payment;
    }
}

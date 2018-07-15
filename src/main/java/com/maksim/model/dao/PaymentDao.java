package com.maksim.model.dao;

import com.maksim.model.domain.Payment;
import com.maksim.model.domain.Ticket;
import com.maksim.model.domain.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public interface PaymentDao {
    int  addPayment(User user, List<Ticket> ticketList, BigDecimal totalPrice);
    Payment findPaymentByPaymentInfo(int userId, BigDecimal totalPrice, Timestamp dateTime);

    Payment findPaymentById(int paymentId);

    void deletePayment(Payment payment);
}

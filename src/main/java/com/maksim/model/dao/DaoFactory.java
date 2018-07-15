package com.maksim.model.dao;



/**
 * Created by Максим on 03/May/18.
 */
public interface DaoFactory {
    UserDao getUserDao();
    ExpositionDao getExpositionDao();
    TicketDao getTicketDao();
    PaymentDao getPaymentDao();
    ShowroomDao getShowroomDao();

}

package com.maksim.model.impl;

import com.maksim.model.dao.*;

/**
 * Created by Максим on 03/May/18.
 */
public class DaoFactoryImpl implements DaoFactory {
    private static final DaoFactoryImpl FACTORY = new DaoFactoryImpl();

    public DaoFactoryImpl() {
    }
    public static DaoFactoryImpl getInstance() {
        return FACTORY;
    }

    @Override
    public UserDao getUserDao() {
            return UserDaoImpl.getInstance();
    }

    @Override
    public ExpositionDao getExpositionDao() {
        return ExpositionDaoImpl.getInstance() ;
    }

    @Override
    public TicketDao getTicketDao() {
        return TicketDaoImpl.getInstance();
    }

    @Override
    public PaymentDao getPaymentDao() {
        return PaymentDaoImpl.getInstance();
    }

    @Override
    public ShowroomDao getShowroomDao() {
        return ShowroomDaoImpl.getInstance();
    }
}

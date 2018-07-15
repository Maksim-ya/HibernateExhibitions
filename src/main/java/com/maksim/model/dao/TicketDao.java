package com.maksim.model.dao;

import com.maksim.model.domain.Ticket;

import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public interface TicketDao {
    List<Ticket> findTicketsByUserByEventDate(int userId);
    boolean addTicket(Ticket ticket);
}

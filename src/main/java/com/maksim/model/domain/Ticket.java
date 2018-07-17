package com.maksim.model.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Максим on 03/May/18.
 */
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int ticketId;
    @ManyToOne
    @JoinColumn (name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn (name = "paymentId")
    private Payment payment;
    @ManyToOne
    @JoinColumn (name = "expositionId")
    private Exposition exposition;
    private int numberOfPersons;
    private LocalDate eventDate;

    public Ticket() {
    }

    public Ticket(int ticketId,User user,Payment payment, Exposition exposition,int numberOfPersons, LocalDate eventDate) {
        this.ticketId = ticketId;
        this.user = user;
        this.payment = payment;
        this.exposition = exposition;
        this.numberOfPersons=numberOfPersons;
        this.eventDate = eventDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (ticketId != ticket.ticketId) return false;
        if (numberOfPersons != ticket.numberOfPersons) return false;
        if (user != null ? !user.equals(ticket.user) : ticket.user != null) return false;
        if (payment != null ? !payment.equals(ticket.payment) : ticket.payment != null) return false;
        if (exposition != null ? !exposition.equals(ticket.exposition) : ticket.exposition != null) return false;
        return eventDate != null ? eventDate.equals(ticket.eventDate) : ticket.eventDate == null;
    }

    @Override
    public int hashCode() {
        int result = ticketId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (exposition != null ? exposition.hashCode() : 0);
        result = 31 * result + numberOfPersons;
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
        return result;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Exposition getExposition() {
        return exposition;
    }

    public void setExposition(Exposition exposition) {
        this.exposition = exposition;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", user=" + user +
                ", payment=" + payment +
                ", exposition=" + exposition +
                ", numberOfPersons=" + numberOfPersons +
                ", eventDate=" + eventDate +
                '}';
    }
}

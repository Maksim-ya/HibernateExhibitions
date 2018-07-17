package com.maksim.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Максим on 03/May/18.
 */
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    @ManyToOne
    @JoinColumn (name = "userId")
    private User user;
    private BigDecimal totalPrice;
    private Timestamp dateTime;

    public Payment() {
    }

    public Payment(int paymentId, User user, BigDecimal totalPrice, Timestamp dateTime) {
        this.paymentId = paymentId;
        this.user = user;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (paymentId != payment.paymentId) return false;
        if (user != null ? !user.equals(payment.user) : payment.user != null) return false;
        if (totalPrice != null ? !totalPrice.equals(payment.totalPrice) : payment.totalPrice != null) return false;
        return dateTime != null ? dateTime.equals(payment.dateTime) : payment.dateTime == null;

    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", user=" + user +
                ", totalPrice=" + totalPrice +
                ", dateTime=" + dateTime +
                '}';
    }
}

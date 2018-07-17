package com.maksim.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Максим on 03/May/18.
 */
@Entity
@Table(name = "expositions")
public class Exposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expositionId;
    private String title;
    private BigDecimal price;
    private String topic;
    @ManyToOne
    @JoinColumn (name = "showroomId")
    private Showroom showroom;
    private LocalDate startDate;
    private LocalDate finishDate;

    public Exposition(int expositionId, String title, BigDecimal price, String topic, Showroom showroom, LocalDate startDate, LocalDate finishDate) {
        this.expositionId = expositionId;
        this.title = title;
        this.price = price;
        this.topic = topic;
        this.showroom = showroom;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public Exposition() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exposition that = (Exposition) o;

        if (expositionId != that.expositionId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;
        if (showroom != null ? !showroom.equals(that.showroom) : that.showroom != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        return finishDate != null ? finishDate.equals(that.finishDate) : that.finishDate == null;

    }

    @Override
    public int hashCode() {
        int result = expositionId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (showroom != null ? showroom.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        return result;
    }

    public int getExpositionId() {
        return expositionId;
    }

    public void setExpositionId(int expositionId) {
        this.expositionId = expositionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Showroom getShowroom() {
        return showroom;
    }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Exposition{" +
                "expositionId=" + expositionId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", topic='" + topic + '\'' +
                ", showroom=" + showroom +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}

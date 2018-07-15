package com.maksim.model.domain;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * Created by Максим on 03/May/18.
 */
@Entity
@Table(name = "showrooms")
public class Showroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showroomId;
    private String title;
    private String address;
    private LocalTime openingTime;
    private LocalTime closingTime;

    public Showroom() {
    }

    public Showroom(int showroomId, String title, String address, LocalTime openingTime, LocalTime closingTime) {
        this.showroomId = showroomId;
        this.title = title;
        this.address = address;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Showroom showroom = (Showroom) o;

        if (showroomId != showroom.showroomId) return false;
        if (title != null ? !title.equals(showroom.title) : showroom.title != null) return false;
        if (address != null ? !address.equals(showroom.address) : showroom.address != null) return false;
        if (openingTime != null ? !openingTime.equals(showroom.openingTime) : showroom.openingTime != null)
            return false;
        return closingTime != null ? closingTime.equals(showroom.closingTime) : showroom.closingTime == null;

    }

    @Override
    public int hashCode() {
        int result = showroomId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (openingTime != null ? openingTime.hashCode() : 0);
        result = 31 * result + (closingTime != null ? closingTime.hashCode() : 0);
        return result;
    }

    public int getShowroomId() {
        return showroomId;
    }

    public void setShowroomId(int showroomId) {
        this.showroomId = showroomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public String toString() {
        return "Showroom{" +
                "showroomId=" + showroomId +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}

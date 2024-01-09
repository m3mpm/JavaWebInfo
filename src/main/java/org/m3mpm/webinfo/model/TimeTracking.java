package org.m3mpm.webinfo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class TimeTracking {

    private Long id;

    private String peer;

    private LocalDate date;

    private LocalTime time;

    private String state;

    public TimeTracking() {
    }

    public TimeTracking(Long id, String peer, LocalDate date, LocalTime time, String state) {
        this.id = id;
        this.peer = peer;
        this.date = date;
        this.time = time;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeer() {
        return peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeTracking that = (TimeTracking) o;
        return Objects.equals(id, that.id) && Objects.equals(peer, that.peer) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, peer, date, time, state);
    }

    @Override
    public String toString() {
        return "TimeTracking{" +
                "id=" + id +
                ", peer='" + peer + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", state='" + state + '\'' +
                '}';
    }
}

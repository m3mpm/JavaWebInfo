package org.m3mpm.webinfo.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "verter")
public class Verter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "check_id")
    private Check checkId;

    @Column(name = "state")
    private String state;

    @Column(name = "time")
    private LocalTime time;

    public Verter() {
    }

    public Verter(Long id, Check checkId, String state, LocalTime time) {
        this.id = id;
        this.checkId = checkId;
        this.state = state;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Check getCheckId() {
        return checkId;
    }

    public void setCheckId(Check checkId) {
        this.checkId = checkId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Verter verter = (Verter) o;
        return Objects.equals(id, verter.id) && Objects.equals(checkId, verter.checkId) && Objects.equals(state, verter.state) && Objects.equals(time, verter.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkId, state, time);
    }

    @Override
    public String toString() {
        return "Verter{" +
                "id=" + id +
                ", checkId=" + checkId +
                ", state='" + state + '\'' +
                ", time=" + time +
                '}';
    }
}

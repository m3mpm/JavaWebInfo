package org.m3mpm.webinfo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Check {
    private Long id;
    private String peer;
    private String task;
    private LocalDate date;

    public Check() {
    }

    public Check(Long id, String peer, String task, LocalDate date) {
        this.id = id;
        this.peer = peer;
        this.task = task;
        this.date = date;
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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Objects.equals(id, check.id) && Objects.equals(peer, check.peer) && Objects.equals(task, check.task) && Objects.equals(date, check.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, peer, task, date);
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", peer='" + peer + '\'' +
                ", task='" + task + '\'' +
                ", date=" + date +
                '}';
    }
}

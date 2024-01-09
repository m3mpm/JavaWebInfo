package org.m3mpm.webinfo.model;

import java.time.LocalTime;
import java.util.Objects;

public class P2P {
    private Long id;
    private Long checkId;
    private String checkingPeer;
    private String state;

    private LocalTime time;

    public P2P() {
    }

    public P2P(Long id, Long checkId, String checkingPeer, String state, LocalTime time) {
        this.id = id;
        this.checkId = checkId;
        this.checkingPeer = checkingPeer;
        this.state = state;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public String getCheckingPeer() {
        return checkingPeer;
    }

    public void setCheckingPeer(String checkingPeer) {
        this.checkingPeer = checkingPeer;
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
        P2P p2P = (P2P) o;
        return Objects.equals(id, p2P.id) && Objects.equals(checkId, p2P.checkId) && Objects.equals(checkingPeer, p2P.checkingPeer) && Objects.equals(state, p2P.state) && Objects.equals(time, p2P.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkId, checkingPeer, state, time);
    }

    @Override
    public String toString() {
        return "P2P{" +
                "id=" + id +
                ", checkId=" + checkId +
                ", checkingPeer='" + checkingPeer + '\'' +
                ", state='" + state + '\'' +
                ", time=" + time +
                '}';
    }
}

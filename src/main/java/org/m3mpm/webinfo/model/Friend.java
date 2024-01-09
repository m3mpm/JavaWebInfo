package org.m3mpm.webinfo.model;

import java.util.Objects;

public class Friend {

    private Long id;

    private String peer1;

    private String peer2;

    public Friend() {
    }

    public Friend(Long id, String peer1, String peer2) {
        this.id = id;
        this.peer1 = peer1;
        this.peer2 = peer2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeer1() {
        return peer1;
    }

    public void setPeer1(String peer1) {
        this.peer1 = peer1;
    }

    public String getPeer2() {
        return peer2;
    }

    public void setPeer2(String peer2) {
        this.peer2 = peer2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(id, friend.id) && Objects.equals(peer1, friend.peer1) && Objects.equals(peer2, friend.peer2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, peer1, peer2);
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", peer1='" + peer1 + '\'' +
                ", peer2='" + peer2 + '\'' +
                '}';
    }
}

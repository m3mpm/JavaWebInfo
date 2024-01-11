package org.m3mpm.webinfo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "peer1")
    private Peer peer1;

    @ManyToOne
    @JoinColumn(name = "peer2")
    private Peer peer2;

    public Friend() {
    }

    public Friend(Long id, Peer peer1, Peer peer2) {
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

    public Peer getPeer1() {
        return peer1;
    }

    public void setPeer1(Peer peer1) {
        this.peer1 = peer1;
    }

    public Peer getPeer2() {
        return peer2;
    }

    public void setPeer2(Peer peer2) {
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
                ", peer1=" + peer1 +
                ", peer2=" + peer2 +
                '}';
    }
}

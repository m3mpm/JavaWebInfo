package org.m3mpm.webinfo.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "transferred_points")
public class TransferredPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "checking_peer")
    private Peer checkingPeer;

    @ManyToOne
    @JoinColumn(name = "checked_peer")
    private Peer checkedPeer;

    @Column(name = "points_amount")
    private Integer pointsAmount;

    public TransferredPoint() {
    }

    public TransferredPoint(Long id, Peer checkingPeer, Peer checkedPeer, Integer pointsAmount) {
        this.id = id;
        this.checkingPeer = checkingPeer;
        this.checkedPeer = checkedPeer;
        this.pointsAmount = pointsAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Peer getCheckingPeer() {
        return checkingPeer;
    }

    public void setCheckingPeer(Peer checkingPeer) {
        this.checkingPeer = checkingPeer;
    }

    public Peer getCheckedPeer() {
        return checkedPeer;
    }

    public void setCheckedPeer(Peer checkedPeer) {
        this.checkedPeer = checkedPeer;
    }

    public Integer getPointsAmount() {
        return pointsAmount;
    }

    public void setPointsAmount(Integer pointsAmount) {
        this.pointsAmount = pointsAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferredPoint that = (TransferredPoint) o;
        return Objects.equals(id, that.id) && Objects.equals(checkingPeer, that.checkingPeer) && Objects.equals(checkedPeer, that.checkedPeer) && Objects.equals(pointsAmount, that.pointsAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkingPeer, checkedPeer, pointsAmount);
    }

    @Override
    public String toString() {
        return "TransferredPoint{" +
                "id=" + id +
                ", checkingPeer=" + checkingPeer +
                ", checkedPeer=" + checkedPeer +
                ", pointsAmount=" + pointsAmount +
                '}';
    }
}

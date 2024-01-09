package org.m3mpm.webinfo.model;

import java.util.Objects;

public class TransferredPoint {

    private Long id;
    private String checkingPeer;
    private String checkedPeer;
    private Integer pointsAmount;

    public TransferredPoint() {
    }

    public TransferredPoint(Long id, String checkingPeer, String checkedPeer, Integer pointsAmount) {
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

    public String getCheckingPeer() {
        return checkingPeer;
    }

    public void setCheckingPeer(String checkingPeer) {
        this.checkingPeer = checkingPeer;
    }

    public String getCheckedPeer() {
        return checkedPeer;
    }

    public void setCheckedPeer(String checkedPeer) {
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
                ", checkingPeer='" + checkingPeer + '\'' +
                ", checkedPeer='" + checkedPeer + '\'' +
                ", pointsAmount=" + pointsAmount +
                '}';
    }
}

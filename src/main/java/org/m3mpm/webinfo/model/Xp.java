package org.m3mpm.webinfo.model;

import java.util.Objects;

public class Xp {
    private Long id;

    private Long checkId;

    private Integer xpAmount;

    public Xp() {
    }

    public Xp(Long id, Long checkId, Integer xpAmount) {
        this.id = id;
        this.checkId = checkId;
        this.xpAmount = xpAmount;
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

    public Integer getXpAmount() {
        return xpAmount;
    }

    public void setXpAmount(Integer xpAmount) {
        this.xpAmount = xpAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xp xp = (Xp) o;
        return Objects.equals(id, xp.id) && Objects.equals(checkId, xp.checkId) && Objects.equals(xpAmount, xp.xpAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkId, xpAmount);
    }

    @Override
    public String toString() {
        return "Xp{" +
                "id=" + id +
                ", checkId=" + checkId +
                ", xpAmount=" + xpAmount +
                '}';
    }
}

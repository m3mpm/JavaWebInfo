package org.m3mpm.webinfo.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "xp")
public class Xp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @OneToOne
    @JoinColumn(name = "check_id")
    private Check checkId;

    @Column(name = "xp_amount")
    private Integer xpAmount;

    public Xp() {
    }

    public Xp(Long id, Check checkId, Integer xpAmount) {
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

    public Check getCheckId() {
        return checkId;
    }

    public void setCheckId(Check checkId) {
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

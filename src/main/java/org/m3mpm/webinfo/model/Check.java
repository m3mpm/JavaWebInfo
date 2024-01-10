package org.m3mpm.webinfo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "checks")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "peer")
    private Peer peer;

    @ManyToOne
    @JoinColumn(name = "task")
    private Task task;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "checkId",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<P2P> p2pList = new ArrayList<>();

    public Check() {
    }

    public Check(Long id, Peer peer, Task task, LocalDate date) {
        this.id = id;
        this.peer = peer;
        this.task = task;
        this.date = date;
    }

    public void addP2P(P2P p2p){
        p2pList.add(p2p);
    }

    public void removeP2P(P2P p2p){
        p2pList.remove(p2p);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Peer getPeer() {
        return peer;
    }

    public void setPeer(Peer peer) {
        this.peer = peer;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<P2P> getP2pList() {
        return p2pList;
    }

    public void setP2pList(List<P2P> p2pList) {
        this.p2pList = p2pList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Objects.equals(id, check.id) && Objects.equals(peer, check.peer) && Objects.equals(task, check.task) && Objects.equals(date, check.date) && Objects.equals(p2pList, check.p2pList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, peer, task, date, p2pList);
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", peer=" + peer +
                ", task=" + task +
                ", date=" + date +
                ", p2pList=" + p2pList +
                '}';
    }
}

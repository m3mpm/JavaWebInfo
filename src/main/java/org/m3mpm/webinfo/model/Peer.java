package org.m3mpm.webinfo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "peers")
public class Peer {

    @Id
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToMany(mappedBy = "peer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Check> checks = new ArrayList<>();

    @OneToMany(mappedBy = "checkingPeer",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<P2P> p2pList = new ArrayList<>();

    @OneToMany(mappedBy = "checkingPeer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransferredPoint> checkingPeers = new ArrayList<>();

    @OneToMany(mappedBy = "checkedPeer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransferredPoint> checkedPeers = new ArrayList<>();


    @OneToMany(mappedBy = "peer1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Friend> friendPeer1 = new ArrayList<>();

    @OneToMany(mappedBy = "peer2", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Friend> friendPeer2 = new ArrayList<>();


    @OneToMany(mappedBy = "peer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recommendation> recommendationPeer = new ArrayList<>();

    @OneToMany(mappedBy = "recommendedPeer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recommendation> recommendedPeer = new ArrayList<>();

    public Peer() {
    }

    public Peer(String nickname, LocalDate birthday) {
        this.nickname = nickname;
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
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
        Peer peer = (Peer) o;
        return Objects.equals(nickname, peer.nickname) && Objects.equals(birthday, peer.birthday) && Objects.equals(checks, peer.checks) && Objects.equals(p2pList, peer.p2pList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, birthday, checks, p2pList);
    }

    @Override
    public String toString() {
        return "Peer{" +
                "nickname='" + nickname + '\'' +
                ", birthday=" + birthday +
                ", checks=" + checks +
                ", p2pList=" + p2pList +
                '}';
    }
}

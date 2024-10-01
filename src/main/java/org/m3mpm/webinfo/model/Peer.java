package org.m3mpm.webinfo.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor(force = true)
@Entity
@Table(name = "peers")
public class Peer {

    @Id
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToMany(mappedBy = "peer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Check> checkPeer = new ArrayList<>();

    @OneToMany(mappedBy = "checkingPeer",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<P2P> p2pCheckingPeer = new ArrayList<>();

    @OneToMany(mappedBy = "checkingPeer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransferredPoint> transferredPointCheckingPeer = new ArrayList<>();

    @OneToMany(mappedBy = "checkedPeer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransferredPoint> transferredPointCheckedPeers = new ArrayList<>();

    @OneToMany(mappedBy = "peer1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Friend> friendPeer1 = new ArrayList<>();

    @OneToMany(mappedBy = "peer2", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Friend> friendPeer2 = new ArrayList<>();

    @OneToMany(mappedBy = "peer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recommendation> recommendationPeer = new ArrayList<>();

    @OneToMany(mappedBy = "recommendedPeer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recommendation> recommendationRecommendedPeer = new ArrayList<>();

    @OneToMany(mappedBy = "peer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeTracking> timeTrackingPeer = new ArrayList<>();

    public Peer() {

    }

//    public Peer(String nickname, LocalDate birthday) {
//        this.nickname = nickname;
//        this.birthday = birthday;
//    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peer peer = (Peer) o;
        return Objects.equals(nickname, peer.nickname) && Objects.equals(birthday, peer.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, birthday);
    }
}

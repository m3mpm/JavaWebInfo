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

    public List<Check> getCheckPeer() {
        return checkPeer;
    }

    public void setCheckPeer(List<Check> checks) {
        this.checkPeer = checks;
    }

    public List<P2P> getP2pCheckingPeer() {
        return p2pCheckingPeer;
    }

    public void setP2pCheckingPeer(List<P2P> p2pList) {
        this.p2pCheckingPeer = p2pList;
    }

    public List<TransferredPoint> getTransferredPointCheckingPeer() {
        return transferredPointCheckingPeer;
    }

    public void setTransferredPointCheckingPeer(List<TransferredPoint> checkingPeers) {
        this.transferredPointCheckingPeer = checkingPeers;
    }

    public List<TransferredPoint> getTransferredPointCheckedPeers() {
        return transferredPointCheckedPeers;
    }

    public void setTransferredPointCheckedPeers(List<TransferredPoint> checkedPeers) {
        this.transferredPointCheckedPeers = checkedPeers;
    }

    public List<Friend> getFriendPeer1() {
        return friendPeer1;
    }

    public void setFriendPeer1(List<Friend> friendPeer1) {
        this.friendPeer1 = friendPeer1;
    }

    public List<Friend> getFriendPeer2() {
        return friendPeer2;
    }

    public void setFriendPeer2(List<Friend> friendPeer2) {
        this.friendPeer2 = friendPeer2;
    }

    public List<Recommendation> getRecommendationPeer() {
        return recommendationPeer;
    }

    public void setRecommendationPeer(List<Recommendation> recommendationPeer) {
        this.recommendationPeer = recommendationPeer;
    }

    public List<Recommendation> getRecommendationRecommendedPeer() {
        return recommendationRecommendedPeer;
    }

    public void setRecommendationRecommendedPeer(List<Recommendation> recommendedPeer) {
        this.recommendationRecommendedPeer = recommendedPeer;
    }

    public List<TimeTracking> getTimeTrackingPeer() {
        return timeTrackingPeer;
    }

    public void setTimeTrackingPeer(List<TimeTracking> timeTrackingPeer) {
        this.timeTrackingPeer = timeTrackingPeer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peer peer = (Peer) o;
        return Objects.equals(nickname, peer.nickname) && Objects.equals(birthday, peer.birthday) && Objects.equals(checkPeer, peer.checkPeer) && Objects.equals(p2pCheckingPeer, peer.p2pCheckingPeer) && Objects.equals(transferredPointCheckingPeer, peer.transferredPointCheckingPeer) && Objects.equals(transferredPointCheckedPeers, peer.transferredPointCheckedPeers) && Objects.equals(friendPeer1, peer.friendPeer1) && Objects.equals(friendPeer2, peer.friendPeer2) && Objects.equals(recommendationPeer, peer.recommendationPeer) && Objects.equals(recommendationRecommendedPeer, peer.recommendationRecommendedPeer) && Objects.equals(timeTrackingPeer, peer.timeTrackingPeer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, birthday, checkPeer, p2pCheckingPeer, transferredPointCheckingPeer, transferredPointCheckedPeers, friendPeer1, friendPeer2, recommendationPeer, recommendationRecommendedPeer, timeTrackingPeer);
    }

    @Override
    public String toString() {
        return "Peer{" +
                "nickname='" + nickname + '\'' +
                ", birthday=" + birthday +
                ", checkPeer=" + checkPeer +
                ", p2pCheckingPeer=" + p2pCheckingPeer +
                ", transferredPointCheckingPeer=" + transferredPointCheckingPeer +
                ", transferredPointCheckedPeers=" + transferredPointCheckedPeers +
                ", friendPeer1=" + friendPeer1 +
                ", friendPeer2=" + friendPeer2 +
                ", recommendationPeer=" + recommendationPeer +
                ", recommendationRecommendedPeer=" + recommendationRecommendedPeer +
                ", timeTrackingPeer=" + timeTrackingPeer +
                '}';
    }
}

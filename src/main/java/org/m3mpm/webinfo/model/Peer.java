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

@Data
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@NoArgsConstructor(force = true)
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
}

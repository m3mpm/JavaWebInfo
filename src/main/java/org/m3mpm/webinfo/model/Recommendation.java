package org.m3mpm.webinfo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "recommendations")
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "peer")
    private Peer peer;

    @ManyToOne
    @JoinColumn(name = "recommended_peer")
    private Peer recommendedPeer;

    public Recommendation() {
    }

    public Recommendation(Long id, Peer peer, Peer recommendedPeer) {
        this.id = id;
        this.peer = peer;
        this.recommendedPeer = recommendedPeer;
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

    public Peer getRecommendedPeer() {
        return recommendedPeer;
    }

    public void setRecommendedPeer(Peer recommendedPeer) {
        this.recommendedPeer = recommendedPeer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recommendation that = (Recommendation) o;
        return Objects.equals(id, that.id) && Objects.equals(peer, that.peer) && Objects.equals(recommendedPeer, that.recommendedPeer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, peer, recommendedPeer);
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "id=" + id +
                ", peer=" + peer +
                ", recommendedPeer=" + recommendedPeer +
                '}';
    }
}

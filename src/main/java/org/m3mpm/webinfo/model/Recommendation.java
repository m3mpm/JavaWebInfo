package org.m3mpm.webinfo.model;

import java.util.Objects;

public class Recommendation {

    private Long id;

    private String peer;

    private String recommendedPeer;

    public Recommendation() {
    }

    public Recommendation(Long id, String peer, String recommendedPeer) {
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

    public String getPeer() {
        return peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public String getRecommendedPeer() {
        return recommendedPeer;
    }

    public void setRecommendedPeer(String recommendedPeer) {
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
                ", peer='" + peer + '\'' +
                ", recommendedPeer='" + recommendedPeer + '\'' +
                '}';
    }
}

package org.m3mpm.webinfo.model;

import java.util.Objects;

public class Peer {
    private String nickname;
    private String birthday;

    public Peer() {
    }

    public Peer(String nickname, String birthday) {
        this.nickname = nickname;
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "Peer{" +
                "nickname='" + nickname + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

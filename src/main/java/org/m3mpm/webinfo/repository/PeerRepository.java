package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.model.Peer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface PeerRepository extends JpaRepository<Peer,String> {
    @Modifying
    @Query("update Peer p set p.nickname = ?2, p.birthday = ?3 where p.nickname = ?1")
    public void updatePeer(String find_nickname, String nickname, LocalDate birthday);
}

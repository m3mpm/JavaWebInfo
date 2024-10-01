package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.model.Peer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PeerRepository extends JpaRepository<Peer,String> {

    /* ver. 1 */
//    @Modifying
//    @Query("update Peer p set p.nickname = ?1, p.birthday = ?2 where p.nickname = ?3")
//    public void updatePeer(String newNickname, LocalDate newBirthday, String findNickname);

    /* ver. 2 */
    @Modifying
    @Query("update Peer p set p.birthday = :newBirthday where p.nickname = :nickname")
    public void updatePeer(
            @Param("nickname") String nickname,
            @Param("newBirthday") LocalDate newBirthday
    );

}

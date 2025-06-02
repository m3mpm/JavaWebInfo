package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.entity.PeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeerRepository extends JpaRepository<PeerEntity,String> {

    @Query("SELECT p FROM PeerEntity p WHERE p.nickname = :nickname")
    Optional<PeerEntity> findPeerEntityByNickname(@Param("nickname") String nickname);
}

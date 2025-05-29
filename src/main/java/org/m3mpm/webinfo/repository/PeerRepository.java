package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.entity.PeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeerRepository extends JpaRepository<PeerEntity,String> {
}

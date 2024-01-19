package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.model.Peer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeerRepository extends JpaRepository<Peer,String> {
}

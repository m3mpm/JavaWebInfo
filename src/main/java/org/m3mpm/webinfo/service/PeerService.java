package org.m3mpm.webinfo.service;

import org.m3mpm.webinfo.dto.PeerDto;

import java.util.List;
import java.util.Optional;

public interface PeerService {
    List<PeerDto> getAllPeers();
    Optional<PeerDto> getPeerById(String id);
    Optional<PeerDto> getPeerByNickname(String name);
    boolean savePeer(PeerDto peerDto);
    boolean deletePeer(PeerDto peerDto);
    void updatePeer(PeerDto peerDto);
}

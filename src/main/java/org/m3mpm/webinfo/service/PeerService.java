package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.model.Peer;
import org.m3mpm.webinfo.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeerService {
    private final PeerRepository peerRepository;

    @Autowired
    public PeerService(PeerRepository peerRepository) {
        this.peerRepository = peerRepository;
    }

    public Iterable<Peer> getAllPeers(){
        return peerRepository.findAll();
    }
}

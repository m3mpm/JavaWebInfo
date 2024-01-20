package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.model.Peer;
import org.m3mpm.webinfo.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PeerService {
    private final PeerRepository peerRepository;

    @Autowired
    public PeerService(PeerRepository peerRepository) {
        this.peerRepository = peerRepository;
    }

    public List<Peer> getAllPeers(){
        return peerRepository.findAll();
    }

    public Peer getPeer(String nickname){
//        return peerRepository.findAll().stream().filter(peer -> peer.getNickname().equals(nickname)).findAny().orElse(null);
        return peerRepository.getReferenceById(nickname);
    }

    public void savePeer(Peer peer){
        peerRepository.save(peer);
    }

    @Modifying
    @Query("update Peer p set p.nickname = ?1, p.birthday = ?2 where p.nickname = ?1")
    public void updatePeer(String nickname, LocalDate birthday){}

    public void deletePeer(Peer peer) {
        peerRepository.delete(peer);
    }

//    public Peer addNewPeer(Peer peer){
//        return peerRepository.save(peer);
//    }
}

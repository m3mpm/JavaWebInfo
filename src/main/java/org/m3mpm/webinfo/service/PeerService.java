package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.model.Peer;
import org.m3mpm.webinfo.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return peerRepository.findAll().stream().filter(peer -> peer.getNickname().equals(nickname)).findAny().orElse(null);
//        return peerRepository.getReferenceById(nickname);
    }

    @Transactional
    public void savePeer(Peer peer){
        peerRepository.save(peer);
    }

    @Transactional
    public void deletePeer(Peer peer) {
        peerRepository.delete(peer);
    }

    /* ver. 1 */
//    @Transactional
//    public void updatePeer(String newNickname, LocalDate newBirthday, String findNickname){
//        peerRepository.updatePeer(newNickname,newBirthday,findNickname);
//    }

    /* ver. 2 */
    @Transactional
    public void updatePeer(String nickname, LocalDate newBirthday){
        if(peerRepository.existsById(nickname)){
            peerRepository.updatePeer(nickname,newBirthday);
        }
    }

    /* ver. 3 */
//    @Transactional
//    public void updatePeer(String nickname, Peer updatedPeer){
//        if (peerRepository.existsById(nickname)){
//            peerRepository.save(updatedPeer);
//        }
//    }

    /* helper methods */
    public boolean isExistsById(String nickname){
        return peerRepository.existsById(nickname);
    }

}

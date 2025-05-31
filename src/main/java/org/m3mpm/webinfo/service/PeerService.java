package org.m3mpm.webinfo.service;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.mapper.PeerMapper;
import org.m3mpm.webinfo.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeerService {

    private final PeerRepository peerRepository;

    private final PeerMapper peerMapper;

    @Autowired
    public PeerService(PeerRepository peerRepository, PeerMapper peerMapper) {
        this.peerRepository = peerRepository;
        this.peerMapper = peerMapper;
    }

    public List<PeerDto> getAllPeers() {
        return peerRepository.findAll().stream().map(peerMapper::peerToPeerDto).collect(Collectors.toList());
    }

    public PeerDto getPeerByNickname(String nickname) {
        PeerDto peerDto = peerRepository.findAll().stream().filter(peer -> peer.getNickname().equals(nickname)).map(peerMapper::peerToPeerDto).findFirst().orElse(null);
        return peerDto;
    }
}

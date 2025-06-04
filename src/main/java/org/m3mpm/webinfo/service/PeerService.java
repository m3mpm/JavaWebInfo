package org.m3mpm.webinfo.service;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.entity.PeerEntity;
import org.m3mpm.webinfo.mapper.PeerMapper;
import org.m3mpm.webinfo.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    /* ver.1 */
//    public Optional<List<PeerDto>> getAllPeers() {
//        List<PeerEntity> peersList = peerRepository.findAll();
//        return peersList.isEmpty() ? Optional.empty() : Optional.of(peersList.stream().map(peerMapper::peerToPeerDto).collect(Collectors.toList()));
//    }

    /* ver.2 */
//    public Optional<List<PeerDto>> getAllPeers() {
//        List<PeerEntity> peersList = peerRepository.findAll();
//
//            return Optional.ofNullable(peersList.isEmpty() ? null : peersList.stream()
//                .map(peerMapper::peerToPeerDto)
//                .collect(Collectors.toList()));
//    }

    /* ver.3 */
    public List<PeerDto> getAllPeers() {
        List<PeerEntity> peersList = peerRepository.findAll();
        return peersList.stream()
                .map(peerMapper::peerToPeerDto)
                .collect(Collectors.toList());
    }

    public Optional<PeerDto> getPeerById(String id) {
        Optional<PeerEntity> optionalPeerEntity = peerRepository.findById(id);
        return optionalPeerEntity.map(peerMapper::peerToPeerDto);
    }

    public Optional<PeerDto> getPeerByNickname(String nickname) {
        Optional<PeerEntity> optionalPeerEntity = peerRepository.findPeerEntityByNickname(nickname);
        return optionalPeerEntity.map(peerMapper::peerToPeerDto);
    }

    public void savePeer(PeerDto peerDto) {
        peerRepository.save(peerMapper.peerDtoToPeer(peerDto));
    }

    public boolean deletePeer(PeerDto deletePeerDto) {
        boolean deleted = false;
        if(peerRepository.existsById(deletePeerDto.getNickname())){
            peerRepository.deleteById(deletePeerDto.getNickname());
            deleted = true;
        }
        return deleted;
    }
}

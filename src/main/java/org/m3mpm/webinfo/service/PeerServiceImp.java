package org.m3mpm.webinfo.service;

import jakarta.transaction.Transactional;
import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.entity.PeerEntity;
import org.m3mpm.webinfo.exception.EntityAlreadyExistsException;
import org.m3mpm.webinfo.exception.EntityNotFoundException;
import org.m3mpm.webinfo.mapper.PeerMapper;
import org.m3mpm.webinfo.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeerServiceImp implements PeerService {

    private final PeerRepository peerRepository;

    private final PeerMapper peerMapper;

    @Autowired
    public PeerServiceImp(PeerRepository peerRepository, PeerMapper peerMapper) {
        this.peerRepository = peerRepository;
        this.peerMapper = peerMapper;
    }

    /* ver.1 */
//    public Optional<List<PeerDto>> getAllPeers() {
//        List<PeerEntity> peersList = peerRepository.findAll();
//        return peersList.isEmpty() ? Optional.empty() : Optional.of(peersList.stream().map(peerMapper::toDto).collect(Collectors.toList()));
//    }

    /* ver.2 */
//    public Optional<List<PeerDto>> getAllPeers() {
//        List<PeerEntity> peersList = peerRepository.findAll();
//
//            return Optional.ofNullable(peersList.isEmpty() ? null : peersList.stream()
//                .map(peerMapper::toDto)
//                .collect(Collectors.toList()));
//    }

    /* ver.3 */
    @Override
    public List<PeerDto> getAllPeers() {
        List<PeerEntity> peersList = peerRepository.findAll();
        return peersList.stream()
                .map(peerMapper::toDto)
                .collect(Collectors.toList());
    }

    /* ver. 1*/
    @Override
    public PeerDto getPeerById(String id) {
        return peerRepository.
                findById(id).
                map(peerMapper::toDto).
                orElseThrow(() -> new EntityNotFoundException("Peer with nickname '" + id + "' not found."));
    }

    /* ver. 2*/
//    @Override
//    public PeerDto getPeerById(String id) {
//        return peerRepository.
//                findById(id).
//                map(peerMapper::toDto).
//                orElseThrow(() -> new EntityNotFoundException("Peer with nickname '" + id + "' not found.", "Peer"));
//    }

    @Override
    public Optional<PeerDto> getPeerByNickname(String nickname) {
        Optional<PeerEntity> optionalPeerEntity = peerRepository.findPeerEntityByNickname(nickname);
        return optionalPeerEntity.map(peerMapper::toDto);
    }

    @Override
    public void savePeer(PeerDto peerDto) {
        if (!peerRepository.existsById(peerDto.getNickname())) {
            peerRepository.save(peerMapper.toEntity(peerDto));
        } else {
            throw new EntityAlreadyExistsException("Peer with nickname '" + peerDto.getNickname() + "' is already exists.");
        }

    }

    @Override
    public void deletePeer(PeerDto peerDto) {
        if (peerRepository.existsById(peerDto.getNickname())) {
            peerRepository.deleteById(peerDto.getNickname());
        } else {
            throw new EntityNotFoundException("Peer with nickname '" + peerDto.getNickname() + "' not found.");
        }
    }

    @Override
    public void updatePeer(PeerDto peerDto) {
        Optional<PeerEntity> optionalPeerEntity = peerRepository.findById(peerDto.getNickname());
        if (optionalPeerEntity.isPresent()) {
            PeerEntity peerEntity = optionalPeerEntity.get();
            peerMapper.updatePeerFromDto(peerDto, peerEntity);
            peerRepository.save(peerEntity);
        }
    }
}

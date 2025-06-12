package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.entity.PeerEntity;
import org.m3mpm.webinfo.exception.EntityNotFoundException;
import org.m3mpm.webinfo.repository.PeerRepository;
import org.m3mpm.webinfo.service.PeerService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PeerMapper {

    @Autowired
    private PeerRepository peerRepository;

    public abstract PeerDto peerToPeerDto(PeerEntity peer);

    public abstract PeerEntity peerDtoToPeer(PeerDto peerDto);

    public abstract void updatePeerFromDto(PeerDto peerDto, @MappingTarget PeerEntity peerEntity);

    @Named("peerEntityToString")
    String peerEntityToString(PeerEntity peerEntity) {
        return peerEntity.getNickname();
    }

    @Named("stringToPeerEntity")
    PeerEntity stringToPeerEntity(String nickname) {
        return peerRepository.findById(nickname).
                orElseThrow(() -> new EntityNotFoundException("Peer with nickname '" + nickname + "' not found."));
    }

}

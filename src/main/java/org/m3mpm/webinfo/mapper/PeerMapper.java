package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.entity.PeerEntity;
import org.m3mpm.webinfo.service.PeerService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PeerMapper {


    private final PeerService peerService;

    @Autowired
    public PeerMapper(PeerService peerService) {
        this.peerService = peerService;
    }

    public abstract PeerDto peerToPeerDto(PeerEntity peer);

    public abstract PeerEntity peerDtoToPeer(PeerDto peerDto);

    public abstract void updatePeerFromDto(PeerDto peerDto, @MappingTarget PeerEntity peerEntity);

    @Named("peerEntityToString")
    String peerEntityToString(PeerEntity peerEntity) {
        return peerEntity.getNickname();
    }

    @Named("stringToPeerEntity")
    PeerEntity stringToPeerEntity(String nickname) {
        return peerService.getPeerById(nickname).map(this::peerDtoToPeer).orElse(new PeerEntity());
    }

}

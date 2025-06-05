package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.entity.PeerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PeerMapper {

    PeerDto peerToPeerDto(PeerEntity peer);

    PeerEntity peerDtoToPeer(PeerDto peerDto);

    void updatePeerFromDto(PeerDto peerDto, @MappingTarget PeerEntity peerEntity);
}

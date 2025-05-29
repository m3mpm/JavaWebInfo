package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.entity.PeerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeerMapper {

    PeerDto peerToPeerDto(PeerEntity peer);

    PeerEntity peerDtoToPeer(PeerDto peerDto);
}

package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.model.Peer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeerMapper2 {
    PeerDto convertToPeerDto(Peer peer);
    Peer convertToPeer(PeerDto peerDto);
}

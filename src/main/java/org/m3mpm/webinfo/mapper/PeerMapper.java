package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.model.Peer;
import org.m3mpm.webinfo.service.PeerService;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PeerMapper {

    @Autowired
    private PeerService peerService;
    public abstract PeerDto convertToPeerDto(Peer peer);
    public abstract Peer convertToPeer(PeerDto peerDto);

    @BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updatePeerFromDto(PeerDto peerDto, @MappingTarget Peer peer);

    String map(Peer peer){
        return peer.getNickname();
    }

    Peer map(String nickname) {
        return peerService.getPeer(nickname);
    }

}

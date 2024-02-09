package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.model.Peer;
import org.m3mpm.webinfo.service.PeerService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PeerMapper {

    private PeerService peerService;

    @Autowired
    public void setPeerService(PeerService peerService) {
        this.peerService = peerService;
    }

    public abstract PeerDto convertToPeerDto(Peer peer);
    public abstract Peer convertToPeer(PeerDto peerDto);

    @BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updatePeerFromDto(PeerDto peerDto, @MappingTarget Peer peer);

    String peerToString(Peer peer){
        return peer.getNickname();
    }

    Peer stringToPeer(String nickname) {
        return peerService.getPeer(nickname);
    }

}

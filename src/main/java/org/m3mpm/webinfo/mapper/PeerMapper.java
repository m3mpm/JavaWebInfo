package org.m3mpm.webinfo.mapper;


import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.model.Peer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeerMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public PeerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PeerDto convertToPeerDto(Peer peer){
        return modelMapper.map(peer, PeerDto.class);
    }

    public Peer convertToPeer(PeerDto peerDto){
        return modelMapper.map(peerDto, Peer.class);
    }
}

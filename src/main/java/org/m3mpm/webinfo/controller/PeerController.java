package org.m3mpm.webinfo.controller;

import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.model.Peer;
import org.m3mpm.webinfo.service.PeerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/peers")
public class PeerController {
    private final PeerService peerService;
    private final ModelMapper modelMapper;

    @Autowired
    public PeerController(PeerService peerService, ModelMapper modelMapper) {
        this.peerService = peerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public String showAllPeers(Model model){
        List<PeerDto> listPeers = peerService.getAllPeers().stream().map(this::convertToPeerDto).collect(Collectors.toList());
        model.addAttribute("listPeers", listPeers);
        return "peer/showAllPeers";
    }

    @GetMapping("/{nickname}")
    public String showPeer(@PathVariable("nickname") String nickname, Model model){
        model.addAttribute("peer",convertToPeerDto(peerService.getPeer(nickname)));
        return "peer/showPeer";
    }


//    @PostMapping
//    public String addNewPeer(Peer peer, Model model){
//        Peer emptyPeer = new Peer();
//        peerService.addNewPeer(peer);
//        return "redirect:/peers";
//    }

    private PeerDto convertToPeerDto(Peer peer){
        return modelMapper.map(peer, PeerDto.class);
    }

    private Peer convertToPeer(PeerDto peerDto){
        return modelMapper.map(peerDto, Peer.class);
    }
}

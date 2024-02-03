package org.m3mpm.webinfo.controller;

import jakarta.validation.Valid;
import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.mapper.PeerMapper;
import org.m3mpm.webinfo.mapper.PeerMapper2;
import org.m3mpm.webinfo.model.Peer;
import org.m3mpm.webinfo.service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/peers")
public class PeerController {
    private final PeerService peerService;
    private final PeerMapper2 peerMapper;

    @Autowired
    public PeerController(PeerService peerService, PeerMapper2 peerMapper) {
        this.peerService = peerService;
        this.peerMapper = peerMapper;
    }

    @GetMapping()
    public String showAllPeers(Model model){
        List<PeerDto> listPeers = peerService.getAllPeers().stream().map(peerMapper::convertToPeerDto).collect(Collectors.toList());
        model.addAttribute("listPeers", listPeers);
        return "peer/showAllPeers";
    }

    @GetMapping("/{nickname}")
    public String showPeer(@PathVariable("nickname") String nickname, Model model){
        model.addAttribute("peer",peerMapper.convertToPeerDto(peerService.getPeer(nickname)));
        return "peer/showPeer";
    }

    @GetMapping("/add")
    public String newPeer(@ModelAttribute("addPeerDto") PeerDto peerDto){
        return "/peer/addPeer";
    }

    @PostMapping("/add")
    public String addPeer(@ModelAttribute("addPeerDto") @Valid PeerDto peerDto, Errors errors){
        if (errors.hasErrors()){
            return "/peer/addPeer";
        }
        peerService.savePeer(peerMapper.convertToPeer(peerDto));
        return "redirect:/peers";
    }

    @PostMapping("/delete")
    public String deletePeer(@ModelAttribute("deletedPeer") PeerDto peerDto){
        Peer peer = peerMapper.convertToPeer(peerDto);
        peerService.deletePeer(peer);
        return "redirect:/peers";
    }

    @GetMapping("/edit/{nickname}")
    public String editPeer(@PathVariable("nickname") String nickname, Model model){
        model.addAttribute("editPeerDto",peerMapper.convertToPeerDto(peerService.getPeer(nickname)));
        return "/peer/editPeer";
    }

    @PostMapping("/edit/{nickname}")
    public String editPeer(@PathVariable("nickname") String nickname, @ModelAttribute("editPeerDto") @Valid PeerDto peerDto, Errors errors){
        if (errors.hasErrors()){
            return "/peer/editPeer";
        }
        Peer peer = peerMapper.convertToPeer(peerDto);
        peerService.updatePeer(nickname,peer);
        return "redirect:/peers";
    }

//    @PostMapping("/edit/{nickname}")
//    public String editPeer(@PathVariable("nickname") String nickname, @ModelAttribute("editPeerDto") @Valid PeerDto peerDto, Errors errors){
//        if (errors.hasErrors()){
//            return "/peer/editPeer";
//        }
//        Peer peer = peerMapper.convertToPeer(peerDto);
//        peerService.updatePeer(peer.getNickname(), peer.getBirthday(), nickname);
//        return "redirect:/peers";
//    }


}

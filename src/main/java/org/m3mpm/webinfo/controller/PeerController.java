package org.m3mpm.webinfo.controller;


import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/peers")
public class PeerController {

    private final PeerService peerService;

    @Autowired
    public PeerController(PeerService peerService) {
        this.peerService = peerService;
    }

    @GetMapping()
    public String showAllPeers(Model model) {
        List<PeerDto> listPeers = peerService.getAllPeers();
        model.addAttribute("listPeers", listPeers);
        return "peer/showAllPeers";
    }

    @GetMapping("/{nickname}")
    public String showPeer(Model model, @PathVariable("nickname") String nickname) {
        model.addAttribute("peer", peerService.getPeerByNickname(nickname));
        return "peer/showPeer";
    }
}

package org.m3mpm.webinfo.controller;

import org.m3mpm.webinfo.model.Peer;
import org.m3mpm.webinfo.service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peers")
public class PeerController {
    private final PeerService peerService;

    @Autowired
    public PeerController(PeerService peerService) {
        this.peerService = peerService;
    }

    @GetMapping
    public String showAllPeers(Model model){
        Iterable<Peer> listPeers = peerService.getAllPeers();
        model.addAttribute("listPeers", listPeers);
        return "peer/showAllPeers";
    }
}

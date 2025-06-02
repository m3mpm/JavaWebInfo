package org.m3mpm.webinfo.controller;


import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/peers")
public class PeerController {

    private final PeerService peerService;

    @Autowired
    public PeerController(PeerService peerService) {
        this.peerService = peerService;
    }


    /* ver.1 */
//    @GetMapping()
//    public String showAllPeers(Model model) {
//        Optional<List<PeerDto>> optionalPeersDto = peerService.getAllPeers();
//        if (optionalPeersDto.isPresent()) {
//            model.addAttribute("listPeers", optionalPeersDto.get());
//            return "peer/showAllPeers";
//        } else {
//            return "redirect:/";
//        }
//    }

    /* ver.2 */
//    @GetMapping()
//    public String showAllPeers(Model model) {
//        List<PeerDto> listPeers = peerService.getAllPeers().orElse(Collections.emptyList());
//        model.addAttribute("listPeers", listPeers);
//        return "peer/showAllPeers";
//    }

    /* ver.3 */
    @GetMapping()
    public String showAllPeers(Model model) {
        List<PeerDto> listPeers = peerService.getAllPeers();
        model.addAttribute("listPeers", listPeers);
        return "peer/showAllPeers";
    }


    @GetMapping("/{nickname}")
    public String showPeer(Model model, @PathVariable("nickname") String nickname) {
        Optional<PeerDto> peerDto = peerService.getPeerByNickname(nickname);
        if (peerDto.isPresent()) {
            model.addAttribute("peerDto", peerDto.get());
        } else {
            model.addAttribute("errorMessage", "Peer with nickname '" + nickname + "' not found.");
        }
        return "peer/showPeer";
    }

    @GetMapping("/{nickname}/edit")
    public String showEditPeer(Model model, @PathVariable("nickname") String nickname) {
        Optional<PeerDto> peerDto = peerService.getPeerByNickname(nickname);
        if (peerDto.isPresent()) {
            model.addAttribute("editPeerDto", peerDto.get());
            return "peer/editPeer";
        } else {
            model.addAttribute("errorMessage", "Peer with nickname '" + nickname + "' not found.");
            return "peer/showPeer";
        }
    }

    @GetMapping("/new")
    public String newPeer(@ModelAttribute("newPeerDto") PeerDto peerDto) {
        return "/peer/newPeer";
    }
}

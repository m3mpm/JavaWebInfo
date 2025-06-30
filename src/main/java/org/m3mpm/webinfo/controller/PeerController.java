package org.m3mpm.webinfo.controller;


import jakarta.validation.Valid;
import org.m3mpm.webinfo.dto.PeerDto;
import org.m3mpm.webinfo.service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        PeerDto peerDto = peerService.getPeerById(nickname);
        model.addAttribute("peerDto", peerDto);
        return "peer/showPeer";

    }

    @GetMapping("/new")
    public String newPeer(@ModelAttribute("newPeerDto") PeerDto peerDto) {
        return "peer/newPeer";
    }

    @PostMapping("/add")
    public String addPeer(Model model, @Valid @ModelAttribute("newPeerDto") PeerDto peerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("newPeerDto", peerDto);
            return "peer/newPeer";
        }
        peerService.savePeer(peerDto);
        return "redirect:/peers";
    }

    @PostMapping("/delete")
    public String deletePeer(@ModelAttribute("deletePeerDto") PeerDto peerDto) {
        peerService.deletePeer(peerDto);
        return "redirect:/peers";
    }

    @GetMapping("/{nickname}/edit")
    public String showEditPeer(Model model, @PathVariable("nickname") String nickname) {
        PeerDto peerDto = peerService.getPeerById(nickname);
        model.addAttribute("editPeerDto", peerDto);
        return "peer/editPeer";
    }

    @PostMapping("/update")
    public String editPeer(Model model, @Valid @ModelAttribute("editPeerDto") PeerDto editPeerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editPeerDto", editPeerDto);
            return "peer/editPeer";
        }
        peerService.updatePeer(editPeerDto);
        return "redirect:/peers";
    }
}

package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.repository.P2PRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class P2PService {
    private final P2PRepository p2pRepository;

    @Autowired
    public P2PService(P2PRepository p2pRepository) {
        this.p2pRepository = p2pRepository;
    }
}

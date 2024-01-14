package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.repository.XpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XpService {
    private final XpRepository xpRepository;

    @Autowired
    public XpService(XpRepository xpRepository) {
        this.xpRepository = xpRepository;
    }
}

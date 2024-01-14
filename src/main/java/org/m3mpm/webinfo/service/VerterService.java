package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.repository.VerterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerterService {
    private final VerterRepository verterRepository;

    @Autowired
    public VerterService(VerterRepository verterRepository) {
        this.verterRepository = verterRepository;
    }
}

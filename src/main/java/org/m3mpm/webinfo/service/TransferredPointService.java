package org.m3mpm.webinfo.service;

import org.m3mpm.webinfo.repository.TransferredPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransferredPointService {
    private final TransferredPointRepository transferredPointRepository;

    @Autowired
    public TransferredPointService(TransferredPointRepository transferredPointRepository) {
        this.transferredPointRepository = transferredPointRepository;
    }
}

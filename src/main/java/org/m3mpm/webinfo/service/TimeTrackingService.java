package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.repository.TimeTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTrackingService {
    private final TimeTrackingRepository timeTrackingRepository;

    @Autowired
    public TimeTrackingService(TimeTrackingRepository timeTrackingRepository) {
        this.timeTrackingRepository = timeTrackingRepository;
    }
}

package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.model.Check;
import org.m3mpm.webinfo.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckService {
    private final CheckRepository checkRepository;

    @Autowired
    public CheckService(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    public List<Check> getAllChecks(){
        return checkRepository.findAll();
    }

    public Check getCheck(Long id){
        return checkRepository.getReferenceById(id);
    }

    @Transactional
    public void saveCheck(Check check){
        checkRepository.save(check);
    }

    @Transactional
    public void deleteCheck(Check check){
        checkRepository.delete(check);
    }

    public boolean isExistsById(Long id){
        return checkRepository.existsById(id);
    }
}

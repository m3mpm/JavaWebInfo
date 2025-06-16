package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.dto.CheckDto;

import java.util.List;

public interface CheckService {

    List<CheckDto> getAllChecks();

    CheckDto getCheckById(Long id);

    void saveCheck(CheckDto checkDto);

    void deleteCheck(CheckDto checkDto);

    void updateCheck(CheckDto checkDto);
}

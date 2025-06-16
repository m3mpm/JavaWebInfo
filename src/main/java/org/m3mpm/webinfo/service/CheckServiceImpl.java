package org.m3mpm.webinfo.service;

import lombok.AllArgsConstructor;
import org.m3mpm.webinfo.dto.CheckDto;
import org.m3mpm.webinfo.entity.CheckEntity;
import org.m3mpm.webinfo.exception.EntityNotFoundException;
import org.m3mpm.webinfo.mapper.CheckMapper;
import org.m3mpm.webinfo.repository.CheckRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CheckServiceImpl implements CheckService {

    private final CheckRepository checkRepository;

    private final CheckMapper checkMapper;

    @Override
    public List<CheckDto> getAllChecks() {
        List<CheckEntity> checkEntities = checkRepository.findAll();
        return checkMapper.toDtoList(checkEntities);
    }

    @Override
    public CheckDto getCheckById(Long id) {
        return checkRepository.findById(id).map(checkMapper::toDto).
                orElseThrow(() -> new EntityNotFoundException("Check with id '" + id + "' not found"));
    }

    @Override
    public void saveCheck(CheckDto checkDto) {
        checkRepository.save(checkMapper.toEntity(checkDto));
    }

    @Override
    public void deleteCheck(CheckDto checkDto) {
        if (checkRepository.existsById(checkDto.getId())) {
            checkRepository.delete(checkMapper.toEntity(checkDto));
        } else {
            throw new EntityNotFoundException("Check with id '" + checkDto.getId() + "' not found");
        }
    }

    @Override
    public void updateCheck(CheckDto checkDto) {
        Optional<CheckEntity> checkEntityOptional = checkRepository.findById(checkDto.getId());
        if (checkEntityOptional.isPresent()) {
            CheckEntity checkEntity = checkEntityOptional.get();
            checkMapper.updateCheckFromDto(checkDto, checkEntity);
            checkRepository.save(checkEntity);
        }
    }
}

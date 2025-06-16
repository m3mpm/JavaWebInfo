package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.CheckDto;
import org.m3mpm.webinfo.entity.CheckEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {PeerMapper.class, TaskMapper.class})
public abstract class CheckMapper {

    @Mappings({
            @Mapping(target = "peer", qualifiedByName = "peerEntityToString"),
            @Mapping(target = "task", qualifiedByName = "taskEntityToString")
    })
    public abstract CheckDto toDto(CheckEntity check);

    @Mappings({
            @Mapping(target = "peer", qualifiedByName = "stringToPeerEntity"),
            @Mapping(target = "task", qualifiedByName = "stringToTaskEntity")
    })
    public abstract CheckEntity toEntity(CheckDto checkDto);

    public abstract List<CheckDto> toDtoList(List<CheckEntity> checkEntities);

    public abstract List<CheckEntity> toEntityList(List<CheckDto> checkDtos);

    @Mappings({
            @Mapping(target = "peer", qualifiedByName = "stringToPeerEntity"),
            @Mapping(target = "task", qualifiedByName = "stringToTaskEntity")
    })
    public abstract void updateCheckFromDto(CheckDto checkDto, @MappingTarget CheckEntity checkEntity);
}

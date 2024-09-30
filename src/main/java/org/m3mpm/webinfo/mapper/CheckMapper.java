package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.CheckDto;
import org.m3mpm.webinfo.model.Check;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {PeerMapper.class, TaskMapper.class})
public abstract class CheckMapper {
    public abstract CheckDto convertToCheckDto(Check check);
    public abstract Check convertToCheck(CheckDto checkDto);
}

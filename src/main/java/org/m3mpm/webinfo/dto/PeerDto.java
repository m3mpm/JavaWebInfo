package org.m3mpm.webinfo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PeerDto {
    private String nickname;
    private LocalDate birthday;
}

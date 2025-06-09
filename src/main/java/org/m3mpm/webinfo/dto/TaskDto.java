package org.m3mpm.webinfo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String title;

    private String parentTask;

    private Integer maxXp;
}

package org.m3mpm.webinfo.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    @NotBlank(message = "Title is required")
    private String title;

    private String parentTask;

    @NotNull(message = "Xp should be not empty")
    @Min(value = 0, message = "Xp should be greater than 0")
    private Integer maxXp;
}

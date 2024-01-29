package org.m3mpm.webinfo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {

    @NotBlank(message = "Title is required")
    private String title;

    private String parentTask;

    @NotEmpty(message = "Xp should be empty")
    @Min(value = 0, message = "Xp should be greater than 0")
    private Integer maxXp;

    @Override
    public String toString() {
        return "TaskDto{" +
                "title='" + title + '\'' +
                ", parentTask='" + parentTask + '\'' +
                ", maxXp=" + maxXp +
                '}';
    }
}

package org.m3mpm.webinfo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class CheckDto {

    private Long id;

    @NotBlank(message = "Peer is required")
    private String peer;

    @NotBlank(message = "Task is required")
    private String task;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate date;

    @Override
    public String toString() {
        return "CheckDto{" +
                "id=" + id +
                ", peer='" + peer + '\'' +
                ", task='" + task + '\'' +
                ", date=" + date +
                '}';
    }
}

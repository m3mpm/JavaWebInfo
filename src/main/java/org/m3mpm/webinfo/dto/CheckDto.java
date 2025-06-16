package org.m3mpm.webinfo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckDto {

    private Long id;

    @NotBlank(message = "Peer is required.")
    private String peer;

    @NotBlank(message = "Task is required.")
    private String task;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Date must be from today and earlier.")
    @NotNull(message = "Date is required.")
    private LocalDate date;
}

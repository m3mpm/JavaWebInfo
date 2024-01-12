package org.m3mpm.webinfo.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@Entity
@Table(name = "verter")
public class Verter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "check_id")
    private Check checkId;

    @Column(name = "state")
    private String state;

    @Column(name = "time")
    private LocalTime time;

}

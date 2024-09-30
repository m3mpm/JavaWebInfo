package org.m3mpm.webinfo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@NoArgsConstructor(force = true)
@Entity
@Table(name = "time_tracking")
public class TimeTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "peer")
    private Peer peer;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "state")
    private Integer state;

}

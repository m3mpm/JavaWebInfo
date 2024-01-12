package org.m3mpm.webinfo.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Table(name = "checks")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "peer")
    private Peer peer;

    @ManyToOne
    @JoinColumn(name = "task")
    private Task task;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "checkId",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<P2P> p2pList = new ArrayList<>();

    @OneToMany(mappedBy = "checkId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Verter> verters = new ArrayList<>();

    @OneToOne(mappedBy = "checkId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Xp xp;

}

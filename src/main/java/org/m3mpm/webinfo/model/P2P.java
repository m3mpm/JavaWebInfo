package org.m3mpm.webinfo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;


@Data
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@NoArgsConstructor(force = true)
@Entity
@Table(name = "p2p")
public class P2P {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "check_id")
    private Check checkId;

    @ManyToOne
    @JoinColumn(name = "checking_peer")
    private Peer checkingPeer;

    @Column(name = "state")
    private String state;

    @Column(name = "time")
    private LocalTime time;

}

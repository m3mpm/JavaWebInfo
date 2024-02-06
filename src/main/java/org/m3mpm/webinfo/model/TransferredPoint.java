package org.m3mpm.webinfo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@NoArgsConstructor(force = true)
@Entity
@Table(name = "transferred_points")
public class TransferredPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "checking_peer")
    private Peer checkingPeer;

    @ManyToOne
    @JoinColumn(name = "checked_peer")
    private Peer checkedPeer;

    @Column(name = "points_amount")
    private Integer pointsAmount;

}

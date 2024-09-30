package org.m3mpm.webinfo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@NoArgsConstructor(force = true)
@Entity
@Table(name = "xp")
public class Xp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @OneToOne
    @JoinColumn(name = "check_id")
    private Check checkId;

    @Column(name = "xp_amount")
    private Integer xpAmount;

}

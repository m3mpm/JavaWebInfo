package org.m3mpm.webinfo.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "parent_task")
    private String parentTask;

    @Column(name = "max_xp")
    private Integer maxXp;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Check> checks = new ArrayList<>();

}

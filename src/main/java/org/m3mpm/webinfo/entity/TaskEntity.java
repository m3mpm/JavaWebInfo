package org.m3mpm.webinfo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "parent_task")
    private String parentTask;

    @Column(name = "max_xp")
    private Integer maxXp;
}
